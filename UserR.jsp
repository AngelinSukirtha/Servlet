<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Registration"%>
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

table {
	margin-top: 70px;
	margin-left: 430px;
}
</style>
</head>
<body>
	<div class="center">
		<h1 style="color: rgb(84, 14, 84);">Registration Successful!</h1>
	</div>
	<table border="1">
		<tr style="background-color: rgb(120, 73, 164); height: 40px;">
			<th style="color: white;">Name</th>
			<th style="color: white;">Email</th>
			<th style="color: white;">Phone Number</th>
		</tr>
		<%
		List<Registration> list = (ArrayList<Registration>) request.getAttribute("list");
		if (list != null) {
			for (Registration r : list) {
		%>
		<tr
			style="color: black; background-color: rgb(167, 167, 193); text-align: center;">
			<td><%=r.getName()%></td>
			<td><%=r.getMailId()%></td>
			<td><%=r.getphoneNumber()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>