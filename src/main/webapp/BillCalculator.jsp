<%@page import="java.util.*"%>
<%@page import ="in.ashwin.service.DisplayManager" %>
<%@page import="in.ashwin.model.PerUnitPrice" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Calculation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="BillGenerate" method="GET">
			<h3>Bill Calculator</h3>
			<br> <label for="type">Type:</label> <select name="type"
				id="selectType" required>
				<option disabled>Select Type</option>
				<option id="selectType" value="DOMESTIC">DOMESTIC</option>
				<option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
			</select><br> <label for="units">Units: </label> <input type="number"
				id="units" name="units" min="1.0" max="100.0" size="16" step="0.01"
				required> <br>
			<button type="submit" class="btn btn-primary">Calculate</button>
</form>
</main>
</body>
</html>