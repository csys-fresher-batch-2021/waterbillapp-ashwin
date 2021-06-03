<%@page import="in.ashwin.model.PerUnitPrice"%>
<%@page import="in.ashwin.service.DisplayManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PricingList</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>PerUnitPriceList</h2>
		<%
		Map<String, List<PerUnitPrice>> map = DisplayManager.getList();
		for (String key : map.keySet()) {
			List<PerUnitPrice> numberOfList = map.get(key);
		%>
		<h3><%=key%></h3>
		<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Units</th>
					<th scope="col">Per Unit Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (PerUnitPrice upi : numberOfList) {
				%>
				<tr>
					<td>
					<%= upi.getMinimumUnits() %> - <%= upi.getMaximumUnits() %>
					</td>
					<td>Rs.<%=upi.getPrice()%>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>

	</main>
</body>
</html>