<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
	<h2>Complete Reservation</h2>
	Airline: ${flight.operatingAirlines}
	<br> Departure City: ${flight.departureCity}
	<br> Arrival City: ${flight.arrivalCity}
	<br> Flight Number: ${flight.flightNumber}

	<form action="completeReservation" method="post">
	<pre>
	<h2>Passenger Details</h2>
First Name: <input type="text" name="passengerFirstName" value="${passenger.firstName}"/>
Last Name: <input type="text" name="passengerLastName" value="${passenger.lastName}"/>
Email: <input type="text" name="passengerEmail" value="${passenger.email}"/>
Phone: <input type="text" name="passengerPhone" value="${passenger.phone}"/>
		
	<h2>Credit Card Information</h2>
Card Number: <input type="text" name="cardNumber"/>
Expiration Date: <input type="text" value="expirationDate"/>
Name: <input type="text" name="nameOnCard"/>
Security Code (3 digits): <input type="password" name="securityCode"/>
	
	<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="Confirm"/>
</pre>
		</form>
</body>
</html>