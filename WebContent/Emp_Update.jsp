<%@page import="org.starlabs.Users.User"%>
<html><head>
</head><br><br><br><br><br>
<head><title> UPDATE CUSTOMER RECORDS </title></head>

<body style="background-image:url(images/background2.jpg)">
<%
User user = (User) session.getAttribute("user");

if(user == null){
	response.sendRedirect("Login.jsp?msg=Your Session has expired. Please Login again.");
} else {%>
<form action="UpdateEmployee" method="get">
<center><h1> Update Records </h1>
<Table align="center" border="5px" width="50%">
<tr>
<td><h2> Enter Employee Id: </h2></td>
<td><input type="text" value="" name="Empid" style="display:table-cell; width:100%; height:100%"></td>
</tr>
<tr>
<td><h2> Select Field For Update: </h2></td>
<td>
<select name="field" style="display:table-cell; width:100%; height:100%">
<option value="name">Name</option>
<option value="email">Email</option>
<option value="salary">Salary</option>
<option value="department">Department</option>
</select>
</td>
</tr>
<tr>
<td><h2> Enter Update Value: </h2></td>
<td><input type="text" value="" name="upData" style="display:table-cell; width:100%; height:100%"></td>
</tr>
<tr>
<td colspan=2> <center><input type="submit" name="submit" value="UPDATE"></center></td>
</tr>
</table>
<div style="color: blue;"><h2>${status}</h2></div>
<h1> <a style="color:blue;text-decoration:none;" href="Home.jsp" > Home Page </a> </h1> </center>
</form>
<%}%>
</body>
</html>