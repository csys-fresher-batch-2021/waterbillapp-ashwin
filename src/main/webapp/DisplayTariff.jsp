<%@page import="java.util.*"%>
<%@page import ="in.ashwin.service.DisplayManager" %>
<%@page import="in.ashwin.model.PerUnitPrice" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PerUnitPricing</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main class="container-fluid">
<h2>Tariff rate</h2>
<%
Map<String,List<PerUnitPrice>>map=DisplayManager.getList();
for (String key : map.keySet()) {
	List<PerUnitPrice> size=map.get(key);
%>
<h3><%=key %></h3>
<table class="table table-bodered">
<caption>Display PerUnitPrice</caption>
<thead>
<tr>
<th scope="col">Number of units</th>
<th scope="col">Tariff rate</th>
</tr>
</thead>
<tbody>
<%
for(PerUnitPrice increase :size){
%>
<tr>
<td> <%=increase.getMinimumUnits() %> - <%=increase.getMaximumUnits() %><td> Rs.<%=increase.getPrice() %> </td>
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