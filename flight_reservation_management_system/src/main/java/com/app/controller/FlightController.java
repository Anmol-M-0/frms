package com.app.controller;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flight;
import com.app.service.FlightService;

@Controller
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	public FlightController() {
		System.out.println("in flight controller " + getClass().getName());
	}

	@GetMapping("/search")
	public String showSearch() {
		// show flight search form?
		System.out.println("in show search " + getClass().getName());
//		hs.setAttribute("search_result", results);

		return "/flights/search";
	}

	@GetMapping("/result")
	public String fetchResult(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam String date, Model modelMap) {
		System.out.println("in fetchresult "+ getClass().getName());
		Set<Flight> results = flightService.findFlightsBy(from, to, LocalDate.parse(date));
		modelMap.addAttribute("search_result", results);
		return "/flights/display";
	}

	@GetMapping("/display")
	public String showFlightList() {
		System.out.println("in show flight list "+getClass().getName() );
		return "/flights/display";
	}

}
