<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
	%>
	<h3>AdminLogin</h3>
	<div class="Adminlogin">
	<form action="AdminLoginFeature" method="post">
	
		<label for="consumerNumber"><strong>Consumer Number:</strong></label><br>
		<input type="text" name="consumerNumber" placeholder="Enter Consumer Number" autofocus required><br>
		<label for="password" ><strong>Password:</strong></label><br>
		<input type="password" name="password" placeholder="Enter your password" required><br>
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
		<button  type="reset" class="btn btn-info">Reset</button>
	</form>
	</div>
	Note:
	<br>
	ConsumerNumber=0323100125
	<br>
	password=Admin@12345
	<br>
	
</main>
</body>
</html>