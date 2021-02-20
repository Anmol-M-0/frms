package com.app.service;

import java.time.LocalDate;
import java.util.Set;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import com.app.pojos.CardInfo;
import com.app.pojos.Flight;
import com.app.pojos.PassengerInfo;
import com.app.pojos.Reservation;
import com.app.pojos.User;


public interface FlightService {
	
		
	
	Set<Flight> findFlightsBy(String from, String to, LocalDate date);
	
	Flight findFlightById(Long flightId);
	
	//add reservation
	User addReservation(Reservation reservation, Long userId);

	void addReservation(User user, Flight flight, PassengerInfo passengerInfo, CardInfo cardInfo);

}
