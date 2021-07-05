<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

</head>
<body>
	<div class="reg">

		<jsp:include page="loginheader.jsp"></jsp:include>
		<main class="container-fluid">

			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<%
			String errormsg = "";
			if (session.getAttribute("ERROR") != null) {
				errormsg = (String) session.getAttribute("ERROR");
			}
			%>


			<h2>REGISTRATION</h2>
			<div class="register">

				<form action="RegisterServlet" method="post">

					<label for="name"><strong>Name:</strong></label><br> <input
						type="text" name="name" placeholder="Enter your name" required
						autofocus><br> <span
						style="color: red; font-style: inherit;"><%=(request.getAttribute("nmsg") == null) ? "" : request.getAttribute("nmsg")%></span>


					<label for="email"><strong>Email Id:</strong></label><br> <input
						type="text" name="email" placeholder="Enter your Email Id"
						required autofocus><br> <span
						style="color: red; font-style: inherit;"><%=(request.getAttribute("emsg") == null) ? "" : request.getAttribute("emsg")%></span>



					<label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
					<input type="number" name="mobileNumber"
						placeholder="Enter your mobileNo" required><br> <span
						style="color: red; font-style: inherit;"><%=(request.getAttribute("mmsg") == null) ? "" : request.getAttribute("mmsg")%></span>

					<label for="ConsumerNumber"><strong>Consumer
							Number:</strong></label><br> <input type="number" name="ConsumerNumber"
						placeholder="Enter your consumer number" required><br> <span
						style="color: red; font-style: inherit;"><%=(request.getAttribute("cnmsg") == null) ? "" : request.getAttribute("cnmsg")%></span>

					<label for="address"><strong>Address:</strong></label><br> <input
						type="text" name="address" placeholder="Enter your Address"
						required autofocus><br> <span
						style="color: red; font-style: inherit;"><%=(request.getAttribute("amsg") == null) ? "" : request.getAttribute("amsg")%></span>


					

					<label for="password"><strong>Set Password:</strong></label><br>
					<input type="password" name="password" placeholder="Example@123"
						required><br>  
					<span style="color: red; font-style: inherit;"><%=(request.getAttribute("umsg") == null) ? "" : request.getAttribute("umsg")%></span>

					<br>
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-danger">Reset</button>
				</form>
			</div>

		</main>

	</div>
</body>
</html>