
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="loginheader.jsp"></jsp:include>
	<main class="container-fluid">



		<h3>Registered Successfully!</h3>
		<br> <span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("regmsg") == null) ? "" : request.getAttribute("regmsg")%></span>
		<br>



	</main>
</body>
</html>