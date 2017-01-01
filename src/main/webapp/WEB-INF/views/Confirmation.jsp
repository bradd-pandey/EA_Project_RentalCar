<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Confirmation</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Please print this page for your confirmation details</h3>
                </td>
            </tr>
            <tr>
                <td>Confirmation Number:</td>
                <td>${sessionScope.confirmation.confirmationNumber}</td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td>${sessionScope.customer.personalDetail.firstName}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>${sessionScope.customer.personalDetail.lastName}</td>
            </tr>
            <tr>
                <td>Vehicle :</td>
                <td>${sessionScope.vehicle.description}</td>
            </tr>
            <tr>
                <td>Pick Up Date:</td>
                <td>${sessionScope.reservation.pickUpDate}</td>
            </tr>
            <tr>
                <td>Return Date:</td>
                <td>${sessionScope.reservation.returnDate}</td>
            </tr>
            <tr>
                <td>Total Amount Charged</td>
                <td>$${sessionScope.reservation.cost}</td>
            </tr>
        </table>
          <spring:url value="/vehicle/showVehicle" var="show" />
		<a href="${show}"><button>Home</button></a>
    </div>
</body>
</html>