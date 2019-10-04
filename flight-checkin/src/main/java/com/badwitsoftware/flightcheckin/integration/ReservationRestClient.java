package com.badwitsoftware.flightcheckin.integration;

import com.badwitsoftware.flightcheckin.integration.dto.Reservation;
import com.badwitsoftware.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
