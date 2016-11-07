<%@page import="org.starlabs.Users.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter Employee</title>
</head>
<body style="background-image:url(images/background2.jpg) ">
<%
User user = (User) session.getAttribute("user");

if(user == null){
	response.sendRedirect("Login.jsp?msg=Your Session has expired. Please Login again.");
} else {%>
<br><br><br><br>
<form action="FilterEmployee" method="get">
<center> 
<h1> FILTER EMPLOYEE </h1>
<table border="1">
<tr><td><h2> Employee Id: </h2></td>
    <td><input type="text" value="" name="Empid"style="display:table-cell; width:100%;height:100%"></td>
	</tr>
	<tr>
	<td colspan=2> <center> <input type="submit" name="submit" value="SUBMIT"> </center></td>
    </tr>
</table>
<div style="color: blue;"><h2>${status}</h2></div>
<h2><a style="color:blue;text-decoration:none;" href="Home.jsp" > Home Page </a></h2>
</center>
</form>
<% } %>
</body>
</html>

