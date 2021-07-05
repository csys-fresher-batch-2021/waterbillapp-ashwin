<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.ashwin.model.UserDetails"%>
<%@page import="in.ashwin.model.Unit"%>
<%@page import="in.ashwin.model.Unit"%>
<%@page import="in.ashwin.service.BillManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payment history</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>payment history</h2>

		<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">USERID</th>
					<th scope="col">NAME</th>
					<th scope="col">MONTH</th>
					<th scope="col">YEAR</th>
					<th scope="col">PAID AMOUNT</th>
					<th scope="col">PAID ON</th>
				</tr>
			</thead>
			<%
			String user = (String) session.getAttribute("user");
				UserDetails bean = new UserDetails();
				bean.getUserid();
				System.out.print(bean.getUserid());
				String sql = "SELECT * FROM bill_calculate where mobileno=? AND status=?";
				Connection con = ConnectionUtil.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, user);
				statement.setString(2, "PAID");
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
			%>


			<tr>
				<td><%=resultSet.getInt("userid")%></td>
				<td><%=resultSet.getString("name")%></td>
				<td><%=resultSet.getString("month")%></td>
				<td><%=resultSet.getString("year")%></td>
				<td><%=resultSet.getDouble("payamt")%></td>
				<td><%=resultSet.getTimestamp("paiddate")%></td>







				<%
				}
				%>
			
		</table>
	</main>
</body>
</html>
