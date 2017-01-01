<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Vehicle</title>
</head>
<body>
	<h1>Add a Vehicle</h1>
	Language : <a href="?language=en_US">English</a>|<a href="?language=ne_NP">Nepali</a><br><br>
	<form:form modelAttribute="newVehicle" enctype="multipart/form-data">
		<p>
			<!-- Vehicle ID: -->
			<spring:message code="vehicleId" text="default text" />
			<form:input id="vehicleId" path="vehicleId" type="text" placeholder="Enter vehicle ID" />
			<form:errors path="vehicleId" cssStyle="color : red;" />
		</p>
		<p>
			<!-- Class: -->
			<spring:message code="vehicleClass" text="default text" />
			<form:select id="vehicleClass" path="vehicleClass.id">
			<%-- 	<form:option value="0" label="--Select Class --" /> --%>
				<form:options items="${vehicleClasses}" itemLabel="classType" itemValue="id" />
			</form:select>
		</p>
		<p>
			<!-- Category: -->
			<spring:message code="category" text="default text" />
			<form:select id="category" path="category.id">
				<%-- <form:option value="0" label="--Select Vehicle --" /> --%>
				<form:options items="${categories}" itemLabel="vehicleType"	itemValue="id" />
			</form:select>
		</p>
		<p>
			<!-- Description: -->
			<spring:message code="description" text="default text" />
			<form:input id="description" path="description" type="text" placeholder="Make, Model .."/>
			<form:errors path="description" cssStyle="color : red;" />
		</p>
		<p>
			<!-- Seat Capacity: -->
			<spring:message code="capacity" text="default text" />
			<form:input id="capacity" path="capacity" type="text" placeholder="Total Available Seats" />
			<form:errors path="capacity" cssStyle="color : red;" />
		</p>
		<p>
			<!-- Allowable Bags: -->
			<spring:message code="bags" text="default text" />
			<form:input id="bags" path="bags" type="text" placeholder=" Number of Bags"/>
			<form:errors path="bags" cssStyle="color : red;" />
		</p>

		<p>
			<!-- Daily Price: -->
			<spring:message code="price" text="default text" />
			<form:input id="price" path="price" type="text" placeholder="99.00" />
			<form:errors path="price" cssStyle="color : red;" />
		</p>
		<p>
			<!-- Special Features: -->
			<spring:message code="specialFeatures" text="default text" />
			<form:textarea id="specialFeatures" path="specialFeatures" rows="2" 
				placeholder="Cruise Control, Automatic, Air Conditioning, AM/FM Stereo and CD"/>
			<form:errors path="specialFeatures" cssStyle="color : red;" />
		</p>
		<p>
			<!-- Upload Image: -->
			<spring:message code="vehicleImage" text="default text" />
			<form:input id="vehicleImage" path="vehicleImage" type="file" />
		</p>
		<p>
			<input type="submit" id="addButton" value="Add Vehicle" />
		</p>
	</form:form>
	<p>
		<spring:url value="/vehicle/showVehicle" var="show" />
		<a href="${show}"><button>Cancel</button></a>
	</p>
</body>
</html>