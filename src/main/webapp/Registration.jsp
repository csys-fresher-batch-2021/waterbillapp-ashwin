<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
	<%
		String existsMessage=request.getParameter("existsMessage");
		if(existsMessage != null){
			out.println("<font color='red'>" + existsMessage + "</font>");
		}
	%>
	
	<form action="RegistrationAction" method="post">
	<label for="name"><strong>Name:</strong></label><br>
	<input type="text" name="name" placeholder="Enter your name" required autofocus><br>
	 
	<label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
	<input type="tel" name="mobileNumber" placeholder="Enter your mobile number" required><br>
	
	<label for="consumerNumber"><strong>Consumer Number:</strong></label><br>
	<input type="tel" name="consumerNumber" placeholder="Enter your consumer number" required><br>
	
	  
	<label for="password"><strong>Set Password:</strong></label><br>
	<input type="password" name="password" placeholder="Enter your password" required><br>
	
	<label for="retypepassword"><strong>Confirm password:</strong></label><br>
	<input type="password" name="confirmpassword" placeholder="Confirm your password" required><br>
	<br>
	<button type="submit" class="btn btn-success">Submit</button>
	<button  type="reset" class="btn btn-warning">Reset</button>
	</form>

</main>
</body>
</html>