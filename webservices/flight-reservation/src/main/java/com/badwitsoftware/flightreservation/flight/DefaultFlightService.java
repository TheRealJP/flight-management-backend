package com.badwitsoftware.flightreservation.flight;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFlightService implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight findById(Long id) {

		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			return flight.get();
		}
		return null;
	}

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

}
