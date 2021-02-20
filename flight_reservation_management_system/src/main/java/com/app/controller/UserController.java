package com.app.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Reservation;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in " + getClass().getName());

	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	@PostMapping("/login")
	public String userAuthenticate(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {

		System.out.println("in auhenticateUser " + getClass().getName());
		try {
			User user = userService.authenticateUser(email, password);
			// vailid login
			// save validated user details in the session scope
			hs.setAttribute("user_details", user);
			hs.setAttribute("message", user.getRole() + ",  " + user.getFirstName() + " " + user.getLastName()
					+ " logged in successfully...");
			if (user.getRole().equals(Role.ADMIN)) {
				System.out.println("admin logged in");
				return "redirect:/admin/home";// needs impl
			}
			return "redirect:/flights/search";// /WEB-INF/views/flights/search.jsp

		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);// javax.persistence.NoResultException
			// add err mesg as the model attribute
			modelMap.addAttribute("message", "Invalid Login ,Please retry!!!!");
			// => invalid login
			return "/user/login";// V.R --> /WEB-INF/views/user/login.jsp

		}

	}

	@GetMapping("/status")
	public String fetchStatusPage(Model modelMap, HttpSession hs) {
		System.out.println("in status handler " +getClass().getName() );
		User user = (User) hs.getAttribute("user_details");
		List<Reservation> reservations = userService.fetchReservations(user.getId());
		modelMap.addAttribute("reservation_list", reservations);

		return "/user/status";
	}

	// add request handling method for user's logout
	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse resp) {
		System.out.println("in userLogout "+ getClass().getName());
		System.out.println("in user logout ");
		// get user details from session scope n add them under model attr map
		modelMap.addAttribute("details", session.getAttribute("user_details"));
		// invalidate session
		session.invalidate();
		// set refresh header to navigate the clnt to home page(index.jsp) after some
		// delay
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/user/logout";// Actual view name : /WEB-INF/views/user/logout.jsp

	}

}
