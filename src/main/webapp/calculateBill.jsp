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
		<form action="GenerateBill" method="Post">
			<br> <br> <br>
			<h3>Bill Calculator</h3>
			<div class="cal">
				<br> <label for="type">Type:</label> <select name="type"
					id="selectType" required>
					<option disabled>Select Type</option>
					<option id="selectType" value="DOMESTIC">HOME</option>
					<option id="selectType" value="COMMERCIAL">COMMERCIAL</option>
				</select><br> <label for="units">Units: </label> <input type="number"
					id="units" name="units" min="1.0" max="1000.0" size="15"
					step="0.01" required> <br>
				<button type="submit" class="btn btn-primary">Calculate</button>
				<button type="reset" class="btn btn-primary">Reset</button>

			</div>
		</form>
	</main>
</body>
</html>