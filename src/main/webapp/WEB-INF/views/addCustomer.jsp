<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <title>register</title>
		 <link rel="stylesheet"
			href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<link rel="stylesheet" href="/resources/demos/style.css">
		<script>
			$(function() {
				$(".datepicker1").datepicker();
			});
		</script>
	</head>
    <body>
       <form:form modelAttribute="newCustomer" method="post">
          <%--   <form:errors path="*" cssClass="errorblock" element="div" /> --%>

            <table width="100%" border="0">
				  <tr>
				    <td><strong>Personal Information</strong></td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td>Title: *</td>
				    <td>
					    <form:input id="personalDetail.title" type="text" path="personalDetail.title" />
					    <form:errors path="personalDetail.title" cssClass="error" />	
				    </td>
				  </tr>
				  <tr>
				    <td width="294">First Name: *</td>
				    <td width="530">
				      <form:input id="personalDetail.firstName" type="text" path="personalDetail.firstName" />
				      <form:errors path="personalDetail.firstName" cssClass="error" />				  
				    </td>
				  </tr>
				  <tr>
				    <td>Middle Name: *</td>
				    <td>
				      <form:input id="personalDetail.middleName" type="text" path="personalDetail.middleName" />
				      <form:errors path="personalDetail.middleName" cssClass="error" />		
				    </td>
				  </tr>
				  <tr>
				    <td>Last Name: *</td>
				    <td>
				      <form:input id="personalDetail.lastName" type="text" path="personalDetail.lastName" />	
				      <form:errors path="personalDetail.lastName" cssClass="error" />	
				    </td>
				  </tr>
				  <tr>
				    <td>Date Of Birth: *</td>
				    <td>
				    	<form:input path="personalDetail.dateOfBirth" class="datepicker1" />
				    	<form:errors path="personalDetail.dateOfBirth" cssClass="error" />
				    </td>
				  </tr>
				  
				  <tr>
				    <td>Customer Email: *</td>
				    <td>
				      <form:input id="personalDetail.customerEmail" type="text" path="personalDetail.customerEmail" />	
				      <form:errors path="personalDetail.customerEmail" cssClass="error" />	
				    </td>

				  </tr>
				   <tr>
				    <td>Customer Phone: *</td>
				    <td>
				      <form:input id="personalDetail.customerPhone" type="text" path="personalDetail.customerPhone" />	
				      <form:errors path="personalDetail.customerPhone" cssClass="error" />	
				    </td>
				  </tr>
				  
				  <tr>
				    <td>User Name: *</td>
				    <td>
				      <form:input id="username" type="text" path="username" />	
				      <form:errors path="username" cssClass="error" />	
				    </td>
				  </tr>
				  
				  <tr>
				    <td>Password: *</td>
				    <td>
				      <form:input id="password" type="password" path="password" />
				      <form:errors path="password" cssClass="error" /> 		
				    </td>
				  </tr>
				  
				  <tr>
				    <td>Drivers License Number:*</td>
				    <td>
				      <form:input id="personalDetail.driverLicenceNumber" type="text" path="personalDetail.driverLicenceNumber" />	
				      <form:errors path="personalDetail.driverLicenceNumber" cssClass="error" />	
				    </td>
				  </tr>
				  
				  <tr>
				    <td>Driver License Using Country Or State: *</td>
				     <td>
				      <form:input id="personalDetail.driverLicenceUsingCountryOrState" type="text" path="personalDetail.driverLicenceUsingCountryOrState" />
				      <form:errors path="personalDetail.driverLicenceUsingCountryOrState" cssClass="error" />		
				    </td>
				  </tr>
				  <tr>
				   <td>Driver License Expiration Date: *</td>
				    <td>
				      	  <form:input path="personalDetail.driverLicenceNumberExpirationDate" class="datepicker1" />
				      	  <form:errors path="personalDetail.driverLicenceNumberExpirationDate" cssClass="error" />
				     </td>
				  </tr>
				  
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td><strong>Billing Address</strong></td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td>Address: *</td>
				    <td>
				      <form:input id="billingAddress.streetName" type="text" path="billingAddress.streetName" />	
				      <form:errors path="billingAddress.streetName" cssClass="error" />	
				    </td>
				  </tr>
				  
				  <tr>
				    <td>City: *</td>
				    <td>
				      <form:input id="billingAddress.city" type="text" path="billingAddress.city" />
				      <form:errors path="billingAddress.city" cssClass="error" />		
				    </td>
				  </tr>
				  <tr>
				    <td>State: *</td>
				    <td>
				      <form:input id="billingAddress.state" type="text" path="billingAddress.state" />
				      <form:errors path="billingAddress.state" cssClass="error" />		
				    </td>
				  </tr>
				  <tr>
				    <td>Zip Code: *</td>
				    <td>
				      <form:input id="billingAddress.zipCode" type="text" path="billingAddress.zipCode" />
				      <form:errors path="billingAddress.zipCode" cssClass="error" />		
				    </td>
				  </tr>
				  
				  <tr>
				    <td>Country: *</td>
				    <td>
				      <form:input id="billingAddress.country" type="text" path="billingAddress.country" />
				      <form:errors path="billingAddress.country" cssClass="error" />		
				    </td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  <tr>
				    <td><strong>Credit Card</strong></td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td>Credit Card Type: *</td>
				    <td>
				      	<form:input path="creditCard.creditcardType" />
				      	<form:errors path="creditCard.creditcardType" cssClass="error" />
				      </td>
				  </tr>
				<tr>
				    <td>Credit Card Number: *</td>
				 
				      <td>
				      	<form:input path="creditCard.creditCardNumber" />
				      	<form:errors path="creditCard.creditCardNumber" cssClass="error" />
				      </td>
				      
				  </tr>
				  <tr>
				    <td>Credit Card Expiration Date: *</td>
				 
				      <td>
				      	<form:input path="creditCard.creditCardExpirationDate" class="datepicker1" />
				      	<form:errors path="creditCard.creditCardExpirationDate" cssClass="error" />
				      </td>
				      
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				  
				  <tr>
				    <td>&nbsp;</td>
				    <td><input type="submit" name="btnbutton" id="btnbutton" value="Submit" />
						<button>Cancel</button></a>
				    <td></td>
				  </tr>
				  <tr>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				    <td>&nbsp;</td>
				  </tr>
				</table>
           
        </form:form>
    </body>
</html>