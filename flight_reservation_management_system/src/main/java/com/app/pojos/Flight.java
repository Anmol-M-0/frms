package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Table(name = "flights")
@Entity
public class Flight extends BaseEntity{
	
	
	@Column(name = "departure_city", length = 20)
	private String departureCity;
	
	
	@Column(name = "arrival_city", length = 20)
	private String arrivalCity;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	
	@Column(name = "departure_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime departureTime;


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalDateTime getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}


	public Flight(String departureCity, String arrivalCity, LocalDate date, LocalDateTime departureTime) {
		super();
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.date = date;
		this.departureTime = departureTime;
	}
	public Flight() {super();}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arrivalCity == null) ? 0 : arrivalCity.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((departureCity == null) ? 0 : departureCity.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrivalCity == null) {
			if (other.arrivalCity != null)
				return false;
		} else if (!arrivalCity.equals(other.arrivalCity))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (departureCity == null) {
			if (other.departureCity != null)
				return false;
		} else if (!departureCity.equals(other.departureCity))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		return true;
	}
	
	
	
}
