<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
<style>
.center {
	text-align: center;
	margin: auto;
	font-size: 15px;
}

table {
	margin-top: 20px;
	margin-left: 100px;
	border-collapse: collapse;
	width: 80%;
}
</style>
</head>
<body>
	<div class="center">
		<h1 style="color: rgb(84, 14, 84);">Login Successful!</h1>
	</div>
	<table border="1">
		<tr style="background-color: purple; height: 40px;">
			<th style="color: white;">User Name</th>
			<th style="color: white;">Email</th>
		</tr>
		<%
		List<Login> list = (ArrayList<Login>) request.getAttribute("list");
		if (list != null) {
			for (Login login : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=login.getUserName()%></td>
			<td><%=login.getEmail()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>
