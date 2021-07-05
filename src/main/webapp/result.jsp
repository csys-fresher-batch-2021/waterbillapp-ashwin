<%@page import="in.ashwin.service.BillManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>calculation</title>


</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<main class="container-fluid">
		<br>
		<br>
		<br>
		<br>

		<div class="rs">

			<%
			Double totalBillAmount = Double.parseDouble(request.getParameter("totalBillAmount"));
			%>
			<table class="table table-bordered">
				<caption></caption>
				<thead class="table-primary">
					<tr>

						<th scope="col">Your Total Bill Amount</th>


					</tr>
				</thead>
				<tbody>
					<tr>



						<td>Rs.<%=totalBillAmount%></td>


					</tr>
				</tbody>
			</table>
		</div>


	</main>
</body>
</html>