<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h5 {
color: red;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">${requestScope.message}</h5>
	<%-- <spring:url  var="url" value="/user/authenticate"/> --%>
	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" name="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>