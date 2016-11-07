<%@page import="org.starlabs.Users.User"%>
<html>
<head><title> DELETE RECORDS </title></head>

<body style="background-image:url(images/background2.jpg)">
<%
User user = (User) session.getAttribute("user");

if(user == null){
	response.sendRedirect("Login.jsp?msg=Your Session has expired. Please Login again.");
} else {%>
<form action="DeleteEmployee" method="get">
<br><br><br><br>
<center> <h1> DELETE EMPLOYEE RECORDS </h1> <br>
<table align="center" border="5px" width="50%">
<tr>
	<td><h2> Employee Id: </h2></td>
	<td><input type="text" value="" name="Empid" style="display:table-cell; width:100%;height:100%"></td>
	</tr>
	<tr>
	<td colspan=2> <center> <input type="submit" name="submit" value="DELETE"> </center> </td>
</tr>
</table>
<div style="color: blue;"><h2>${status}</h2></div>
<h2><a style="color:blue;text-decoration:none;" href="Home.jsp" > Home Page </a></h2>
</center>
</form>
<%} %>
</body>
</html>