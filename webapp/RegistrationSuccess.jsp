<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
<style>
.center {
	text-align: center;
	margin: auto;
	font-size: 15px;
}
table{
margin-top:70px;
margin-left:250px;
}
</style>
</head>
<body>
	<div class="center">
		<h1 style="color:rgb(84, 14, 84);">Registration Successful!</h1>
	</div>
	<table border="1">
		<tr style="background-color:rgb(120, 73, 164); height: 40px;">
			<th style="color:white;" >First Name</th>
			<th style="color:white;" >Last Name</th>
			<th style="color:white;" >User Name</th>
			<th style="color:white;" >Password</th>
			<th style="color:white;" >Confirm Password</th>
			<th style="color:white;" >Email</th>
			<th style="color:white;" >Phone Number</th>
			<th style="color:white;" >Gender</th>
		</tr>
		<%
		ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
		if (list != null) {
			for (Employee emp : list) {
		%>
		<tr style="color:black; background-color:rgb(167, 167, 193); text-align: center;">
			<td><%=emp.getFirstName()%></td>
			<td><%=emp.getLastName()%></td>
			<td><%=emp.getUserName()%></td>
			<td><%=emp.getPassword()%></td>
			<td><%=emp.getConfirmPassword()%></td>
			<td><%=emp.getEmail()%></td>
			<td><%=emp.getPhoneNo()%></td>
			<td><%=emp.getGender()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>
