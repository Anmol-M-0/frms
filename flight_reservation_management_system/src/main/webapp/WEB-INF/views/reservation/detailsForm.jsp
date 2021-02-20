<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--making a form binding using spring suppiled form tab lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger details form</title>
</head>
<body>
	<h5>Message : ${requestScope.message}, you have chosen
		${requestScope.flight}</h5>
	<%--make this flight thing a lil' better organised, maybe a table. --%>
	<h5>Message : ${sessionScope.message}</h5>
	<table>
		<thead>
			<tr>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Date</th>
				<th>Departure</th>
			</tr>
		</thead>
		<tr>
			<td>${flight.departureCity}</td>
			<td>${flight.arrivalCity}</td>
			<td>${flight.date}</td>
			<td>${flight.departureTime}</td>
		</tr>
	</table>


	<form:form method="post" modelAttribute="passengerInfo">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><form:input path="middleName"/></td>
				<td><form:errors path="middleName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName"/></td>
			</tr>
			<tr>
			<td>Email</td>
			<td><form:input type="email" path="email" /></td>
			<td><form:errors path="email"/></td>
			</tr>
			<tr>
			<td>Phone Number</td>
			<td><form:input path="phone" /></td><%---type="tel" pattern="[6-9]{1}[0-9]{9}"  --%>
			<td><form:errors path="phone"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" value="Enter Details"/></td>
			</tr>


		</table>
	</form:form>
</body>
</html>