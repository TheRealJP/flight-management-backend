package com.badwitsoftware.flightreservation.flight;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {

	private final Logger log = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam(value = "departureDate", required = false) @DateTimeFormat(pattern = "yyyy-mm-dd") Date departureDate,
			ModelMap modelMap) {
		log.info("Finding flights: {}, {}, {}", from, to, departureDate);

		List<Flight> flights;
		Optional<Date> date = Optional.ofNullable(departureDate);

		if (date.isPresent()) {
			flights = flightRepository.findByDepartureCityAndArrivalCityAndDateOfDeparture(from, to, date.get());
		} else {
			flights = flightRepository.findByDepartureCityAndArrivalCity(from, to);
		}

		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}

	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
}
