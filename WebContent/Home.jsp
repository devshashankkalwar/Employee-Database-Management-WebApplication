<%@page import="java.io.PrintWriter"%>
<%@page import="org.starlabs.Users.User"
import ="java.util.*" 
import="org.starlabs.EmployeDatabaseManagement.Employee"%>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EMPLOYEE MANAGEMENT SYSTEM</title>
    
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
<title> WELCOME TO EMPLOYEE MANAGEMENT SYSTEM </title></head>

<body style="background-image:url(images/background.jpg)">
<%
User user = (User) session.getAttribute("user");

if(user == null){
	response.sendRedirect("Login.jsp?msg=Your Session has expired. Please Login again.");
} else {%>
	



<br>
<br>
   <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="Home.jsp">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
            <li role="presentation"><a href="logout.do">LogOut</a></li>
          </ul>
        </nav>
      </div>
      </div>
      <div class="jumbotron">
        <center><h2>WELCOME TO EMPLOYEE DATABASE MANAGEMENT SYSTEM</h2></center>
      </div>
<br>
<br>
<br>
<center>
	<div class="container">
      	<div class="row">
        <div class="col-lg-12">
          	<p>
            <a href="Emp_Insert.jsp" class="btn btn-primary btn-lg btn-block">Insert Record</a>
            <a href="Emp_Update.jsp" class="btn btn-danger btn-lg btn-block">Update Record</a>
            <a href="Emp_Filter.jsp" class="btn btn-default btn-lg btn-block">Filter Record</a>
            <a href="Emp_Delete.jsp" class="btn btn-warning btn-lg btn-block">Delete Record</a>
            <a href="Employee_SelectAll" class="btn btn-success btn-lg btn-block" >Fetch All Records</a>
          	</p>
        </div>
		</div>
		</div>

		<br>
		<br> 
		<% List<Employee> allEmpList = (ArrayList<Employee>)request.getAttribute("empList");
		if(allEmpList!=null){%>
			<h2 align="center"><b>Employee Table</b> </h2>
			<div class="dropdown" align="right" style="margin-bottom:10px; margin-right:100px">
  			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
  			<span class="caret"></span></button>
  			<ul class="dropdown-menu dropdown-menu-right">
    			<li><a href="Employee_SelectAll?sort=byname">Name</a></li>
    			<li><a href="Employee_SelectAll?sort=bysalary">Salary</a></li>
   	 			<li><a href="Employee_SelectAll?">ID</a></li>
  			</ul>
			</div>


<div class="table-responsive">
<table class="table table-striped width" style="border:solid">
<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Salary (INR)</th><th>Department</th></tr>
</thead>
<tbody>
	<%for (Employee emp:allEmpList){%>
		<tr><td><%=emp.getId()%></td>
		<td><%=emp.getName()%> </td>
		<td><%=emp.getEmail() %> </td>
		<td><%=emp.getSalary()%></td>
		<td><%=emp.getDepartment()%></td></tr>
	<%}%>
</tbody>
</table>
</div>
<%} %>
<div style="color: blue;"><h2>${status}<h2></div>
 	 <div class="mastfoot">
  	<div class="inner">
  	<p>&copy; <a href="#">All rights reserved to sTArLaBs</a>, by <a href="#">develpoers@starlabs</a>.</p>
  	</div>
	</div>
</center>

 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
<%}%>
</body>
</html>