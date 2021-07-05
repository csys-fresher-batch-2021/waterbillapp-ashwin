<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.ashwin.dao.CalculationDAO"%>
<%@page import="in.ashwin.model.CalcBill"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>bill payment</title>

</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<br> <br>

		<%
		String id = request.getParameter("id");
		CalcBill bill = CalculationDAO.getRecordById(Integer.parseInt(id));
		int id2 = bill.getId();
		System.out.print("ID2 IS " + id2);
		%>
		<%
		double result = 0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "SELECT*FROM bill_calculate where id=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id2);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			result = resultSet.getDouble("totalamount");
			System.out.println(result);
		}
		%>
		<div class="bill">
			<form action="paymentservlet" method="post">

				<input type="hidden" name="id" value="<%=bill.getId()%>">
				<h2>Bill Payment</h2>
				<h4>card details:</h4>
				<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>
				<table>
					<tr>
						<td><label>UPI ID:</label></td>
						<td><input type="text" name="upi id"
							placeholder="XXXX@upi" required></td>
					</tr>
					<tr>
						<td><label>UPI PIN:</label></td>
						<td><input type="password" name="UPI pin" placeholder="Valid 6 digit UPI pin"
							maxlength="6" required></td>
					</tr>
					<tr>
						<td><label>Bill Amount:</label></td>
						<td><input type="number" name="bamt" value="<%=result%>"></td>
					</tr>
					<tr>
				</table>
				
				<button type="submit" class="btn btn-primary"
					action="/waterbillapp-ashwin/src/servlet/paymentservlet"
					name="Action" value="Pay Bill">Pay Bill</button>

			</form>
		</div>
	</main>

</body>