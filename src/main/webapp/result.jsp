<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Calculation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main class="container-fluid">
<%
Double totalBill=Double.parseDouble(request.getParameter("totalBill"));
%>
Total Bill Amount is Rs. <%= totalBill %>
</main>
</body>
</html>