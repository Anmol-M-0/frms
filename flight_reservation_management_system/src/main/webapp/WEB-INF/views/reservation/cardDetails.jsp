<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Payment Details</title>
</head>
<body>
	<h5>Enter card details</h5>
	<form:form method="post" modelAttribute="cardInfo">

		<table>
			<tr>
				<td>Card Number</td>
				<td><form:input path="cardNo" /></td>
				<td><form:errors path="cardNo" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Exp date</td>
				<td><form:input type="date" path="expDate" /></td>
				<td><form:errors path="expDate" /></td>
			</tr>
			<tr>
				<td>cvv</td>
				<td><form:input path="cvv" /></td>
				<td><form:errors path="cvv" /></td>
			</tr>
		</table>
		<input type="submit"" value="Enter Details" />
	</form:form>
</body>
</html>