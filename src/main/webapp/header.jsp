<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
String role = (String) session.getAttribute("ROLE");
%>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Water Bill
			Calculation</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<%
				if (role != null && role.equalsIgnoreCase("admin")) {
				%>
				<li class="nav-item"><a class="nav-link" href="Pricing.jsp">Pricing
						List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="BillCalculator.jsp">Bill Calculator</a></li>
				<%
				}
				%>
			</ul>
			<%
			if (role == null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogin.jsp">AdminLogin</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Registration.jsp">Register</a></li>

			</ul>
			<%
			}
			if (role != null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogOutAction">Log out</a></li>
			</ul>
			<%
			}
			%>


		</div>
	</nav>
</header>