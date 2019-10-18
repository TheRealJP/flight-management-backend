package com.travelab.checkin.integration;

import com.travelab.checkin.integration.dto.Reservation;
import com.travelab.checkin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
