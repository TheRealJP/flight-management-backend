package com.badwitsoftware.flightreservation.flight;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

	List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String departureCity, String arrivalCity,
			Date date);
}
