package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	public HomePageController() {
	System.out.println("in homePAgeController " +getClass().getSimpleName());
		
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/")
	public String provideHomePage() {
		System.out.println("in show home page");
		return "/index";//Actual view name reted by V.R : /WEB-INF/views/index.jsp --- logical view name
	}
}
