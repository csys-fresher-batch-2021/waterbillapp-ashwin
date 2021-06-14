<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">



<%
String role = (String) session.getAttribute("ROLE");
String LoginUser=(String)session.getAttribute("LOGINUSER");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">Water Bill Calculation</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
    
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <%if(role!=null && role.equalsIgnoreCase("admin")) {%>
      <li class="nav-item">
        <a class="nav-link" href="Pricing.jsp">Pricing List</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="BillCalculator.jsp">Bill Calculator</a>

      </li>
      <%} %>
      
      <%if(LoginUser!=null && LoginUser.equalsIgnoreCase("user")){ %>
      <li class="nav-item">
        <a class="nav-link" href="Pricing.jsp">Pricing List</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="BillCalculator.jsp">Bill Calculator</a>
      </li>
       <%} %>
      
    </ul> <%if(role==null && LoginUser==null){ %>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="UserLogin.jsp">UserLogin</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="AdminLogin.jsp">AdminLogin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Registration.jsp">Register</a>
      </li>
      </ul>
      <%} if(role!=null){%>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
      <a class="nav-link" href="AdminLogout">Log out</a>
      </li>
      </ul>
      <%} %>
      <% if(LoginUser!=null){ %>
       <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
      <a class="nav-link" href="UserLogout">Log out</a>
      </li>
      </ul>
      <%} %>
      
   
  </div>
</nav>
</header>