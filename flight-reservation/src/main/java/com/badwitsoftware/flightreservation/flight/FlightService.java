package com.badwitsoftware.flightreservation.flight;

import java.util.List;

public interface FlightService {

	Flight findById(Long id);
	
	List<Flight> findAll();
}
