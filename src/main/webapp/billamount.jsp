<%@page import="java.sql.ResultSet"%>
<%@page import="in.ashwin.util.ConnectionUtil"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="in.ashwin.model.*"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>bill amount</title>
</head>
<body>
<jsp:include page="header2.jsp"></jsp:include>

	<main class="container-fluid">
	
<form class="example" action=""  >

<strong><label style="color: red;"> User Id</label></strong>
  <input type="search" class="form-control rounded" placeholder="Search By Id" name="userid" >
</form>
<br>

	<% 
	String id=request.getParameter("userid");
String sql=null;
PreparedStatement statement=null;
if(id!=null )
{
	Connection con = ConnectionUtil.getConnection();
	sql="SELECT * FROM bill_calculate WHERE STATUS= 'Pending' AND userid='"+id+"'";
    statement=con.prepareStatement(sql);
    }


else
{
	Connection con = ConnectionUtil.getConnection();
	sql="SELECT userid,name,address,month,year,unitConsumed,totalamount FROM bill_calculate WHERE STATUS= 'Pending'  ORDER BY ID DESC ";
    statement=con.prepareStatement(sql);
}
     ResultSet resultSet=statement.executeQuery();
%>


	
	
	<table class="table table-bordered">
			<caption></caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">USER ID</th>
				   <th scope="col">NAME</th>
				   <th scope="col">ADDRESS</th>
				   <th scope="col">MONTH</th>
				   <th scope="col">YEAR</th>
				 <th scope="col">UNIT</th>
				<th scope="col">BILL AMOUNT</th>
				</tr>
			</thead>
		<tbody>
		<%
		while(resultSet.next())
		{
		%>
	<tr>
	<td><%=resultSet.getInt("userid") %></td>
	
	<td><%=resultSet.getString("name") %></td>
	<td><%=resultSet.getString("address") %></td>	
	<td><%=resultSet.getString("month") %></td>	
	<td><%=resultSet.getString("year") %></td>	
		<td><%=resultSet.getDouble("unitConsumed") %></td>
	
	<td>Rs.<%=resultSet.getDouble("totalamount") %></td>
	
     </tr>
                <%
				}
				%>
</tbody>
		</table>


	</main>
</body>
</html>