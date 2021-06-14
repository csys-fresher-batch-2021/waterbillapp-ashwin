<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>

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
	
	<h2>Login</h2>
			<div class="Userlogin">
	
	<form action="UserLogin" method="post">
	
		<label for="mobileNumber"><strong>mobileNumber:</strong></label><br>
		<input type="text" name="mobileNumber" placeholder="Enter your mobile Number" autofocus required><br>
		<label for="password" ><strong>Password:</strong></label><br>
		<input type="password" name="password" placeholder="Enter your password" required><br>
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
		<button  type="reset" class="btn btn-danger">Reset</button>
	</form>
	</div>
	
</main>
</body>
</html>