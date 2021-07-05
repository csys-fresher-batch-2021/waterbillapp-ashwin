<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>success</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">



		<br> <span
			style="color: #00e676; font-style: inherit; font-size: 30px;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>

		<br>



	</main>
</body>
</html>