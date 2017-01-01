<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<spring:url value="/vehicle/addVehicle" var="url" />
	<a href="${url}"><button>Add Vehicle</button></a>
	<spring:url value="/addCustomer" var="cus" />
	<a href="${cus}"><button>Register</button></a>
	<security:authorize access="isAnonymous()">
	<spring:url value="/login" var="cus" />
	<a href="${cus}"><button>Login</button></a>
	</security:authorize>

	<!-- spring security -->
	<security:authorize access="isAuthenticated()">
		<spring:url value="/doLogout" var="lg" />
		<a href="${lg}"><button style="margin: 10px">Logout</button></a>
	</security:authorize>

	<h1>Car Rental Agency</h1>
	<div style="text-align: center">
		<c:forEach items="${vehicles}" var="vehicle">
			<div style="float: left; padding: 10px">
				<img
					src="<c:url value="/resources/images/${vehicle.vehicleId}.png"/>"
					alt="image" style="width: 400px; height: 300px" />
				<h4>${vehicle.description}</h4>
				<p>Price: $${vehicle.price}</p>
				<p>
					<a
						href=" <spring:url value="/vehicle/vehicleDetail?id=${vehicle.vehicleId}" /> ">
						<button>See Details</button>
					</a>

					<!-- spring security -->
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<a
							href=" <spring:url value="/vehicle/removeVehicle?id=${vehicle.id}" /> ">
							<button>Remove</button>
						</a>
					</security:authorize>
				</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
