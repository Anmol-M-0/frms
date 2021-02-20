package com.app.service;

import java.time.LocalDate;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CardRepository;
import com.app.dao.FlightRepository;
import com.app.dao.PassengerRepository;
import com.app.dao.ReservationRepository;
import com.app.dao.UserRepository;
import com.app.exceptions.InvalidFlightException;
import com.app.exceptions.UserHandlingException;
import com.app.pojos.Card;
import com.app.pojos.CardInfo;
import com.app.pojos.Flight;
import com.app.pojos.PassengerInfo;
import com.app.pojos.Reservation;
import com.app.pojos.User;


@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Set<Flight> findFlightsBy(String from, String to, LocalDate date) {
		System.out.println("in findFLightsBy "+getClass().getName());
		Set<Flight> flights = flightRepository.findByDepartureCityAndArrivalCityAndDate(from, to, date);

		return flights;
	}

	@Override
	public User addReservation(Reservation reservation, Long userId) {
		System.out.println("in addReservation1"+getClass().getName());
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserHandlingException("an error occured: invalid id"));
		user.getReservations().add(reservation);
//can i do the opposite -> i.e. add reservation to the reservation repo, and then 		

		return user;
	}

	@Override
	public void addReservation(User user, Flight flight, PassengerInfo passengerInfo, CardInfo cardInfo) {
		System.out.println("in add reservation2 "+getClass().getName());
		Reservation reservation = new Reservation(user, flight, passengerInfo);
		Reservation savedEntity = reservationRepository.save(reservation);
//		Passenger passenger = PassengerUtils.addInfo(passengerInfo);
//		passenger.setReservation(savedEntity);
//		passengerRepository.save(passenger);//is it necessary?, how will res connect to this?
		System.out.println(cardInfo.getCardNo()+", "+ cardInfo.getName()+", "+cardInfo.getExpDate()+", "+ cardInfo.getCvv());
		Card card = new Card(cardInfo.getCardNo(), cardInfo.getName(), LocalDate.parse(cardInfo.getExpDate()), cardInfo.getCvv());
		System.out.println(card);
		cardRepository.save(card);
		
		
//		user.getReservations().add(savedEntity);//=> should i add it?
//		//to test=> we'll skip it for now
//		if(!reservation.equals(savedEntity)) {
//			throw new ReservationHandlingException("an error occured during reservation");
//		}

	}

	@Override
	public Flight findFlightById(Long flightId) {
		System.out.println("in findFLightsById "+getClass().getName());
		return flightRepository.findById(flightId)
					.orElseThrow(() -> new InvalidFlightException("invalid flight id!!"));

	}

}
