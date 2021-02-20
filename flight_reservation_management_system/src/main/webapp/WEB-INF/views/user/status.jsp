<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User status page</title>
</head>
<body>
	<h5>Message : ${requestScope.message}</h5>
	<h5>Message : ${sessionScope.message}</h5>
	<table>
		<thead>
			<tr>
				<th>Reservation Id</th>
				<th>Passenger Name</th>
				<th>Flight ID</th>
				<th>From</th>
				<th>To</th>
				<th>Date</th>
				<th>Departure</th>
			</tr>
		</thead>

		<%---list reservations --%>
		<c:forEach var="r" items="${requestScope.reservation_list}">
			<tr>
				<td>${r.id}</td>
				<td>${r.passenger.firstName}, ${r.passenger.lastName}</td>
				<td>${r.flight.id}</td>
				<td>${r.flight.departureCity}</td>
				<td>${r.flight.arrivalCity}</td>
				<td>${r.flight.date}</td>
				<td>${r.flight.departureTime}</td>
			</tr>
		</c:forEach>

	</table>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Out</a>
	</h5>
</body>
</html>