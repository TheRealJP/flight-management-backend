package com.travelab.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelab.checkin.integration.ReservationRestClient;
import com.travelab.checkin.integration.dto.Reservation;
import com.travelab.checkin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {

	@Autowired
	private ReservationRestClient client;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = client.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckin")

	public String completeCheckin(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {
		
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setBags(numberOfBags);
		request.setCheckedIn(true);
		
		client.updateReservation(request);
		return "checkinConfirmation";

	}
}
