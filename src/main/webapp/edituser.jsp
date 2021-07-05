<%@page import="in.ashwin.dao.RegistrationDAO"%>
<%@page import="in.ashwin.model.UserDetails"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User List</title>

</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<main class="container-fluid">

		<%
		String id = request.getParameter("id");
		UserDetails user=RegistrationDAO.getRecordById(Integer.parseInt(id));
		%>

		<form action="EditSevlet" method="post">
			<h3>Edit the user</h3>

			<span style="color: #00e676; font-style: inherit;"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span>

			<input type="hidden" name="id" value="<%=user.getUserid()%>"><br>

			<label for="address">Name</label> <input type="text"
				class="form-control" id="address" placeholder="Another input"
				name="name" value="<%=user.getName()%>"> 
				
				<label for="email">Email</label>
			<input type="text" class="form-control" id="email"
				placeholder="Another input" name="email"
				value="<%=user.getEmail()%>">
				
				 <label for="mobile">Mobile</label>
			<input type="text" class="form-control" id="mobile"
				placeholder="Another input" name="mobile"
				value="<%=user.getMobileno()%>"> 
				
				<label for="address">Address</label>
			<input type="text" class="form-control" id="address"
				placeholder="Another input" name="address"
				value="<%=user.getAddress()%>"><br>

			<button type="submit" class="btn btn-success">Edit </button>


		</form>
	</main>
</body>
</html>