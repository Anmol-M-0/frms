package com.app.dao;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
	Set<Flight> findByDepartureCityAndArrivalCityAndDate(String departureCity, String arrivalCity, LocalDate date);

}
