package com.badwitsoftware.flightreservation.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.badwitsoftware.flightreservation.flight.Flight;
import com.badwitsoftware.flightreservation.flight.FlightController;
import com.badwitsoftware.flightreservation.flight.FlightService;

@Controller
public class ReservationController {
	private final Logger log = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private FlightService flightService;

	@GetMapping("/showCompleteReservation")
	public String showReservationForm(@RequestParam("flightId") Long id, ModelMap modelMap) {
		log.info("showReservationForm() for flight id: {}", id);
		Flight flight = flightService.findById(id);

		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation with id: " + reservation.getId() + " created successfully.");
		return "reservationConfirmation";
	}

	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable Long id) {
		return reservationService.findReservation(id);
	}

	@PutMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		return reservationService.updateReservation(request);
	}
}
