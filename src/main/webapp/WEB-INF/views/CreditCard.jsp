<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
 <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Payment</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Please press confirm to make payment, and cancel to start again</h3>
                </td>
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
                <td>Total Cost</td>
                <td>$${sessionScope.reservation.cost}</td>
            </tr>
        </table>
        	<br>
        	<br>
          <form:form action="payment/completeReservation" method="post">
          <input type="submit" value="Confirm" />
          </form:form>
  			<br>
          <spring:url value="/vehicle/showVehicle" var="url" /><a href="${url}"><button>Cancel</button></a>
          
    </div>
</body>
</html>