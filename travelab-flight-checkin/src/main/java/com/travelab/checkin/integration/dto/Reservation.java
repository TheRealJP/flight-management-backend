package com.travelab.checkin.integration.dto;

public class Reservation {
	private Long id;
	private boolean checkedIn;
	private int bagCount;
	private Passenger passenger;
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

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
