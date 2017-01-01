<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script> -->
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> -->
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/isAvailable.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/dateValidation.js"/>"></script>

<title>Vehicle Details</title>
</head>
<body>
	<h1>Vehicle Details</h1>
	<div>
		<h3 style="color:gray">This is ${vehicle.vehicleClass.classType} class ${vehicle.category.vehicleType} having Vehicle ID: ${vehicle.vehicleId} </h3>
	<h4>Make/Model: ${vehicle.description}</h4>
	<h4>Available Seats: ${vehicle.capacity}</h4>
	<h4>Baggage: ${vehicle.bags}</h4>
	<h4>Price: $ ${vehicle.price}</h4>
	<h4>Special Features: ${vehicle.specialFeatures}</h4>
	<p>
		<spring:url value="/vehicle/showVehicle" var="home" /><a href="${home}"><button>Back</button></a>
		<button onclick="showHiddenForm(); return false;">Check Availability</button>
		
	</p>
	</div>
	<div id = "checkDiv" style="display:none">
		<h3>Enter Checkout and Return Date: </h3>
		<h2 id="no" style="color:red; display:none">Sorry! The selected Vehicle is already BOOKED!</h2>
		<h2 id="yes" style="color:green; display:none">Congratulation! The selected Vehicle is AVAILABLE!</h2>
		<form id="checkForm">
			<p>
			Pickup Date:
			<input id="checkoutDate" name="checkoutDate" type="text"/>
			</p>
			<p>
			Return Date:
			<input id="returnDate" name="returnDate" type="text" />
			</p>
			<%-- <input id="vehicleId" type="hidden" value="${vehicle.vehicleId}"> --%>
			<button onclick="isAvailable(${vehicle.vehicleId});return false;" >Submit</button>			
		</form>
		<a href="<spring:url value="/reservation?id=${vehicle.vehicleId}"/>">
			<button id="book" style="display:none">Book Now</button></a>		
	</div>
</body>
</html>