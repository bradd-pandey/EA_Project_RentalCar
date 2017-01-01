<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/dateValidation.js"/>"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<title>ReservationForm</title>
<!-- <script>
	$(function() {
		//$(".datepicker").datepicker();
		$("#startDate").datepicker({			
	        onSelect: function(selected) {	
	          $("#endDate").datepicker("option","minDate", selected)
	        }
		});
		
$("#endDate").datepicker({
	        onSelect: function(selected) {	
	        	 $("#startDate").datepicker("option","maxDate", selected)
	        }			
				 
		});
	});

</script> -->
</head>
<body>
<div align="center">
        <form:form id="eventForm" action="reservation" method="post" commandName="reservationForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Reservation Form</h2></td>
                </tr>
                <tr>
                    <td>Pick Up Date (mm/dd/yyyy):</td>
                    <td><form:input path="pickUpDate" class="datepicker" id="checkoutDate"/></td>
                    <form:errors path="pickUpDate" cssStyle="color : red;" />
                </tr>
                <tr>
                    <td>Return Date (mm/dd/yyyy):</td>
                    <td><form:input path="returnDate" class="datepicker" id="returnDate" /></td>
                     <form:errors path="returnDate" cssStyle="color : red;" />
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Reserve" /></td>
                </tr>
            </table>
        </form:form>
        </div>
</body>
</html>