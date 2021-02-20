package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.utils.PassengerUtils;

@Entity
public class Reservation extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
//	@OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL) <= wrong
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id")
	private Flight flight;
	@OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Passenger passenger;//this association can later also be turned into one to many, right?
	public Reservation(User user, Flight flight, PassengerInfo info) {
		super();
		this.user = user;
		this.flight = flight;
		addPassenger(info);
	}
	public Reservation(User user, Flight flight) {
		super();
		this.user = user;
		this.flight = flight;
	}
	public Reservation(User user, Flight flight, Passenger passenger) {
		super();
		this.user = user;
		this.flight = flight;
		this.passenger = passenger;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Reservation() {
		super();
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public void addPassenger(PassengerInfo info) {
		passenger = PassengerUtils.addInfo(info);
		passenger.setReservation(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Reservation other = (Reservation) obj;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
