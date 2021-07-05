<%@page import="in.ashwin.dao.CalculationDAO"%>
<%@page import="in.ashwin.model.CalcBill"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="in.ashwin.model.UserDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ViewBill</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ViewBill</h3>
		<br>

		<%
		String user = (String) session.getAttribute("user");

		UserDetails bean = new UserDetails();
		Connection connection = null;
		PreparedStatement pst = null;
		System.out.println(user);
		connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,userid,name,unitConsumed,year,month,totalamount,status FROM bill_calculate  WHERE mobileno=?";
		pst = connection.prepareStatement(sql);
		pst.setString(1, user);
		ResultSet resultSet = pst.executeQuery();
		%>


		<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">USERID</th>
					<th scope="col">NAME</th>
					<th scope="col">UNIT</th>
					<th scope="col">YEAR</th>
					<th scope="col">MONTH</th>
					<th scope="col">BILLAMOUNT</th>
					<th scope="col">STATUS</th>
					<th scope="col">ACTION</th>
				</tr>
			</thead>

			<%
			while (resultSet.next()) {
			%>


			<tbody>
				<tr>
					<td><%=resultSet.getInt("id")%></td>
					<td><%=resultSet.getInt("userid")%></td>
					<td><%=resultSet.getString("name")%></td>
					<td><%=resultSet.getDouble("unitConsumed")%></td>
					<td><%=resultSet.getString("year")%></td>
					<td><%=resultSet.getString("month")%></td>
					<td><%=resultSet.getDouble("totalamount")%></td>
					<td><%=resultSet.getString("status")%></td>


					<%
					String a = resultSet.getString("status");
					System.out.print("value of a is " + a);
					if (a.equals("PAID")) {
					%>

					<td></td>

					<%
					} else {
					%>

					<td><a class="btn btn-primary"
						href="paybill.jsp?id=<%=resultSet.getInt("id")%>"
						onclick="return true">Pay</a></td>


					<%
					}
					%>



				</tr>

				<%
				}
				%>





			</tbody>

		</table>

	</main>

</body>
</html>
