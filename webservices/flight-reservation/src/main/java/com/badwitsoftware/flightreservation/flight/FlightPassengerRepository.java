package com.badwitsoftware.flightreservation.flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightPassengerRepository extends JpaRepository<FlightPassenger, Long> {

}
