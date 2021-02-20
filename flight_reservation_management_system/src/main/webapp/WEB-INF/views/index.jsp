<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome 2 Spring MVC !!!!!</h4>
	<h5>
		<a href="<spring:url value='/user/login'/>">Sign in</a>
	</h5>
	<%-- <h5>
	<a href="<spring:url value='/user/signup'/>">Sign up</a>
	</h5> --%>
</body>
</html>