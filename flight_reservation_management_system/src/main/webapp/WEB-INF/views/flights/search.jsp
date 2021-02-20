<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Message : ${requestScope.message}</h5>
	<h5>Message : ${sessionScope.message}</h5>
	<form method="get" action="result">
		<table>
			<tr>
				<td>from</td>
				<td><input type="text" name="from"/></td>
			</tr>
			<tr>
				<td>to</td>
				<td><input type="text" name="to"/></td>
			</tr>
			<tr>
				<td>departure date</td>
				<td><input type="date" name="date"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="search" /></td>
			</tr>

		</table>
	</form>

</body>
</html>