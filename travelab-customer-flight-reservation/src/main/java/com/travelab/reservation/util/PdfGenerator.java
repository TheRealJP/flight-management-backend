package com.travelab.reservation.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.travelab.reservation.reservation.Reservation;

@Component
public class PdfGenerator {

	private static final Logger log = LoggerFactory.getLogger(PdfGenerator.class);

	public void generateIterary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {
			FileOutputStream outputStream = new FileOutputStream(filePath);
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			document.add(generateTable(reservation));
			document.close();
			outputStream.close();
			log.info("Itinerary successfully generated for {}", reservation.getFlight().getOperatingAirlines());
		} catch (DocumentException | IOException e) {
			log.error(e.getMessage());
		}

	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("FlightPassenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}
}
