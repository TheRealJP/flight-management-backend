package com.badwitsoftware.flightreservation.reservation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badwitsoftware.flightreservation.flight.Flight;
import com.badwitsoftware.flightreservation.flight.FlightService;
import com.badwitsoftware.flightreservation.flight.FlightPassenger;
import com.badwitsoftware.flightreservation.flight.FlightPassengerRepository;
import com.badwitsoftware.flightreservation.util.EmailGenerator;
import com.badwitsoftware.flightreservation.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	private FlightPassengerRepository flightPassengerRepository;
	private ReservationRepository reservationRepository;
	private FlightService flightService;
	private PdfGenerator pdfGenerator;
	private EmailGenerator emailGenerator;

	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository,
			FlightPassengerRepository flightPassengerRepository, FlightService flightService, PdfGenerator pdfGenerator,
			EmailGenerator emailGenerator) {
		this.reservationRepository = reservationRepository;
		this.flightPassengerRepository = flightPassengerRepository;
		this.flightService = flightService;
		this.pdfGenerator = pdfGenerator;
		this.emailGenerator = emailGenerator;
	}

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		// generate then save the passenger
		FlightPassenger passenger = new FlightPassenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		FlightPassenger savedPassenger = flightPassengerRepository.save(passenger);

		// generate then save the reservation
		Long flightId = request.getFlightId();
		Flight flight = flightService.findById(flightId);

		Reservation reservation = new Reservation();
		reservation.setPassenger(savedPassenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);

		// create and send itinerary via pdf/email respectively
		String filePath = "pathToReservationPdf" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateIterary(savedReservation, filePath);
		emailGenerator.sendItineraryToEmail(passenger.getEmail(), filePath);
		return savedReservation;
	}

	@Override
	@Transactional
	public Reservation findReservation(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isPresent()) {
			return reservation.get();
		}
		return null;
	}

	@Override
	@Transactional
	public Reservation updateReservation(ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setBagCount(request.getBags());
		return reservationRepository.save(reservation);
	}

	@Override
	public void cancelReservation(Long id) {
		reservationRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Reservation> findAllReservations() {
		return reservationRepository.findAll();
	}
}
