package com.travelab.reservation.flight;

import java.util.List;

public interface FlightService {

	Flight findById(Long id);
	
	List<Flight> findAll();
}
