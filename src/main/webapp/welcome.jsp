<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
</head>
<body>
	<main class="container-fluid">
		<jsp:include page="loginheader.jsp"></jsp:include>

		<br> <br> <br> <br>

		<h3>Welcome To Water Billing system</h3>

		<p>Login to Pay your Bills</p>
		<p class="lead">
			<a class="btn btn-primary btn-lg" href="login.jsp" role="button">Login</a>
		</p>
	</main>
</body>
</html>