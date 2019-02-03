<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
Airlines: ${reservation.flight.operatingAirlines}<br>
Flight No: ${reservation.flight.flightNumber}<br>
Departure City: ${reservation.flight.departureCity}<br>
Arrival City: ${reservation.flight.arrivalCity}<br>
Date of Departure: ${reservation.flight.dateOfDeparture}<br>
Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br>

<h2>Passenger Details</h2>
First Name: ${reservation.passenger.firstName}<br>
Last Name: ${reservation.passenger.lastName}<br>
Phone: ${reservation.passenger.phoneNumber}<br>
Email: ${reservation.passenger.email}<br>

<form action="completeCheckin" method="post">
Enter number of bags for checkin: <input type="text" name="numberOfBags"/>
<input type="hidden" value="${reservation.id}" name="reservationId"/><br>
<input type="submit" value="Check In"/>
</form>

</body>
</html>