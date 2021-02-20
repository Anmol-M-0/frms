<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
background-color: cyan;
margin: auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>message : ${sessionScope.message}</h5>
<h5>Last Action Status : ${requestScope.message}</h5><!--  -->
	<table>
		<caption>Flight List</caption>
		<thead>
			<tr>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Date</th>
				<th>Departure</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="f" items="${requestScope.search_result}">
				<tr>
					<td>${f.departureCity}</td>
					<td>${f.arrivalCity}</td>
					<td>${f.date}</td>
					<td>${f.departureTime}</td>
					<td><a href="<spring:url value='/reservation/detailsForm?fid=${f.id}'/>">Select</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h5><a href="<spring:url value='/user/logout'/>">Logout</a></h5>

</body>
</html>