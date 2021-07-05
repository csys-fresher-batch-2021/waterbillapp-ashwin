<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BillCalculation</title>

</head>

<body>

	<jsp:include page="header2.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>
			<strong>Enter Bill Information</strong>
		</h3>
		<div class="cal">


				<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>

			<form action="CalcBillCtrl" method="post">


				<br> <label for="">UserId</label><br> <input type="text"
					placeholder="Search.." name="userid" pattern="\d*" required>
				<input type="submit" name="Action" value="Search"
					class="btn btn-info"> <br>
			</form>
			<br>


			<%
			int count = 0;
			if (request.getAttribute("UList") != null) {
				ArrayList al = (ArrayList) request.getAttribute("UList");
				System.out.println(al);
				Iterator itr = al.iterator();
				while (itr.hasNext()) {

					count++;
					ArrayList pList = (ArrayList) itr.next();
			%>


			<form action="CalcBillCtrl" method="post">

				<label for="">UserId</label><br> <input type="text"
					value="<%=pList.get(0)%>" name="userid" ><br>


				<label for="name">Name</label><br> <input type="text" id="name"
					name="name" value="<%=pList.get(1)%>"><br>
					
					 <label for="consumerno">Consumer No</label><br> <input type="text"
					id="consumerno" name="consumerno" value="<%=pList.get(2)%>"
					><br> 
					
					<label for="mobileno">Mobile number
					</label><br> <input type="text" id="exampleInputPassword1"
					name="mobileno" value="<%=pList.get(3)%>" ><br>




				<label for="address">Address</label><br> <input type="text"
					id="address" name="address" value="<%=pList.get(4)%>"><br>

				<label for="type">Type</label><br> <select name="type"
					id="selectType" required>
					<option disabled>Select Type</option>
					<option id="selectType" value="DOMESTIC">DOMESTIC</option>
					<option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
				</select><br> <label for="unitConsumed">Unit Consumed</label> <br>
				<input type="number" id="unitConsumed" placeholder="Enter Unit"
					name=unitConsumed pattern="\d*" id="unitConsumed" min="1.0" max="100.0"
					step="0.01" required><br>  <label
					for="year">Year</label><br> <input type="number"
					placeholder="yyyy" name="year" pattern="\d*" id="year" required><br>
				<label for="month">Month</label><br> <select name="month">
					<option value="January">January</option>
					<option value="February">February</option>
					<option value="March">March</option>
					<option value="April">April</option>
					<option value="May">May</option>
					<option value="June">June</option>
					<option value="July">July</option>
					<option value="August">August</option>
					<option value="September">September</option>
					<option value="October">October</option>
					<option value="November">November</option>
					<option value="Decemeber">December</option>
				</select><br> <span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>

				<br>
				<button type="submit" class="btn btn-primary" name="Action"
					value="Calculate Bill">Calculate Bill</button>
				<button type="reset" class="btn btn-danger">Reset</button>

				<%
				}
				}
				if (count == 0) {
				%>

				<strong>Enter valid Record</strong>


				<%
				}
				%>


			</form>

		</div>
	</main>
</body>
</html>