<%@page import="in.ashwin.dao.RegistrationDAO"%>
<%@page import="in.ashwin.model.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:include page="loginheader.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Login</h3>


		<div class="login">

			<span style="color: red; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
			<form action="LoginCtrl" method="post">


				<label for="mobilenumber"><strong>Mobile Number:</strong></label><br>
				<input type="text" name=mobilenumber placeholder="Enter your mobile number"
					autofocus required><br> <label for="password"><strong>Password:</strong></label><br>
				<input type="password" name="password"
					placeholder="Enter your password" required><br> <br>
				<button type="submit" class="btn btn-success">Login</button>
				<button type="reset" class="btn btn-danger">Reset</button>


			</form>
		</div>
	</main>
</body>
</html>