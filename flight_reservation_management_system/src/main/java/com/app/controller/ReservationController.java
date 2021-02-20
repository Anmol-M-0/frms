package com.app.controller;

import static com.app.utils.PassengerUtils.addInfo;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.FlightRepository;
import com.app.dao.UserRepository;
import com.app.exceptions.InvalidFlightException;
import com.app.pojos.CardInfo;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.pojos.PassengerInfo;
import com.app.pojos.Reservation;
import com.app.pojos.User;
import com.app.service.FlightService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private FlightService flightService;
	public ReservationController() {
	System.out.println("in reservation controller "+getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/detailsForm")
	public String fetchReservationDetailsForm(@RequestParam("fid") Long flightId, Model modelMap) {
		System.out.println("in fetchReservationDetailsForm "+getClass().getName());
		Flight flight = flightService.findFlightById(flightId);
		
		// => valid flight id
		modelMap.addAttribute("flight", flight);
		modelMap.addAttribute(new PassengerInfo());
		
		return "/reservation/detailsForm";// views/reservation/detailsForm.jsp

	}

	@PostMapping("/detailsForm")
	public String processReservationDetailsForm(PassengerInfo passengerInfo, BindingResult result, RedirectAttributes flashMap,
			Model modelMap, HttpSession hs) {
		System.out.println("in processReservationDetailsForm "+getClass().getName());
		if (result.hasErrors())
			return "/reservation/detailsForm";
		
		hs.setAttribute("flight", (Flight)modelMap.getAttribute("flight"));
		hs.setAttribute("passengerInfo", passengerInfo);
		
//		flightService.addReservation(user, flight, passengerInfo);
//		Reservation reservation = new Reservation(user, (Flight)modelMap.getAttribute("flight"), passengerInfo);
//		user.getReservations().add(reservation);

		return "redirect:/reservation/cardDetails";//views/reservation/cardDetails.jsp
	}
	@GetMapping("/cardDetails")
	public String fetchCardDetailsForm(Model modelMap) {
		System.out.println("in fetchCardDetailsForm "+getClass().getName());
		modelMap.addAttribute(new CardInfo());
		return "/reservation/cardDetails";//views/reservation/cardDetails.jsp
	}
	@PostMapping("/cardDetails")
	public String processReservation(CardInfo cardInfo, BindingResult result, RedirectAttributes flashMap,
			Model modelMap, HttpSession hs) {
		System.out.println(" in processReservation "+getClass().getName());
		User user = (User)hs.getAttribute("user_details");
		Flight flight = (Flight)hs.getAttribute("flight");
		PassengerInfo passengerInfo = (PassengerInfo)hs.getAttribute("passengerInfo");
		flightService.addReservation(user, flight, passengerInfo, cardInfo);
		
		return "redirect:/user/status";
	}
	
}
