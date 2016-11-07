<%@page import="org.starlabs.Users.User"%>
<html>
<head>
</head><br><br><br><br><br>
<head><title> EMPLOYEE DATABASE MANAGEMENT </title><head>

<body style="background-image:url(images/background2.jpg)">
<%
User user = (User) session.getAttribute("user");

if(user == null){
	response.sendRedirect("Login.jsp?msg=Your Session has expired. Please Login again.");
} else {%>
<form action="InsertEmployee" method="get">
<center><h1> INSERT EMPLOYEE RECORDS <h1><center>
<Table align="center" border="5px" width="50%">
<tr>
	<td><h2> Employee Id :<h2></td>
	<td> <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' value="" name="Empid" style="display:table-cell; width:100%;height:100%"></td>
</tr>
<tr>
	<td><h2> Employee Name :<h2></td>
	<td> <input type="text" value="" name="Empname" style="display:table-cell; width:100%;height:100%"></td>
</tr>
<tr>
	<td> <h2>Employee Email :<h2></td>
	<td><input type="text" value="" name="Empemail" style="display:table-cell; width:100%;height:100%"></td>
</tr>

<tr>
	<td> <h2>Employee Salary :<h2></td>
	<td><input type="number" step="0.01" value="0.00" name="Empsalary" style="display:table-cell; width:100%;height:100%"></td>
</tr>

<tr>
	<td> <h2>Employee Department :<h2></td>
	<td><input type="text"  value="" name="Empdepartment" style="display:table-cell; width:100%; height:100%"></td>
</tr>

<tr>

<td colspan=2> <center> <input type="submit" name="submit" value="INSERT"> </center> </td>


</tr>
</table>
<div id ="error" style="color: #FF0000;">${Message}</div>
<a style="color:blue;text-decoration:none;" href="Home.jsp" > Home Page </a>
</form>
<%}%>
</body>
</html>
