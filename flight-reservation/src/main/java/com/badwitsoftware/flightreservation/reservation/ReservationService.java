package com.badwitsoftware.flightreservation.reservation;

import java.util.List;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);

	Reservation findReservation(Long id);

	Reservation updateReservation(ReservationUpdateRequest request);

	void cancelReservation(Long id);

	List<Reservation> findAllReservations();
}
