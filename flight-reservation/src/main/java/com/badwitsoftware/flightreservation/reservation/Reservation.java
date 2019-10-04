package com.badwitsoftware.flightreservation.reservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.badwitsoftware.flightreservation.flight.Flight;
import com.badwitsoftware.flightreservation.flight.FlightPassenger;

@Entity
public class Reservation  {

	@Id
	@GeneratedValue
	@Column(updatable = false)
	private Long id;

	private boolean checkedIn;
	private int bagCount;

	@OneToOne
	private FlightPassenger flightPassenger;

	@OneToOne
	private Flight flight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getBagCount() {
		return bagCount;
	}

	public void setBagCount(int bagCount) {
		this.bagCount = bagCount;
	}

	public FlightPassenger getPassenger() {
		return flightPassenger;
	}

	public void setPassenger(FlightPassenger flightPassenger) {
		this.flightPassenger = flightPassenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
