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

		<form>
			<br> <label>Search</label> <input type="text" name="userId">
		</form>
		<br>

		<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">

				<tr>
					<th scope="col">User Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile no</th>
					<th scope="col">Consumer no</th>
					<th scope="col">Address</th>
					<th scope="col">Action</th>
				</tr>
				<tr>
					<%
					String id = request.getParameter("userId");
					Connection con = ConnectionUtil.getConnection();
					String sql = null;
					PreparedStatement statement = null;
					if (id != null) {
						con = ConnectionUtil.getConnection();
						sql = "SELECT * FROM user_details WHERE USERID='"+id+"'";
						statement = con.prepareStatement(sql);

					} else {
						con = ConnectionUtil.getConnection();
						sql = "SELECT * from user_details WHERE ROLEID=2";
						statement = con.prepareStatement(sql);

					}
					ResultSet rs = statement.executeQuery();

					while (rs.next()) {
					%>
					<td><%=rs.getInt("userid")%></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("email")%></td>
					<td><%=rs.getString("mobileno")%></td>
					<td><%=rs.getString("consumerno")%></td>
					<td><%=rs.getString("address")%></td>
					<td><a href="edituser.jsp?id=<%=rs.getInt(1)%>"
						class="btn btn-success">Edit</a> <a
						href="deleteuser.jsp?id=<%=rs.getInt(1)%>" class="btn btn-danger">Delete</a></td>
				</tr>

				<%
				}
				%>
			
		</table>
	</main>
</body>
</html>