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
	margin-top: 20px;
	margin-left: 100px;
	border-collapse: collapse;
	width: 80%;
}
</style>
</head>
<body>
	<div class="center">
		<h1 style="color: rgb(84, 14, 84);">Registration Successful!</h1>
	</div>
	<div style="margin-left: 840px;">
		<form method="post" action="SearchServlet">
			<input type="text" name="search" placeholder="Search name.."
				style="border-color: purple; background-color: white">
			<button type="submit" name="search"
				style="background-color: purple; color: white">Search</button>
		</form>
	</div>
	<table border="1">
		<tr style="background-color: purple; height: 40px;">
			<th style="color: white;">Name</th>
			<th style="color: white;">Email</th>
			<th style="color: white;">Phone Number</th>
			<th style="color: white;" colspan="2">Actions</th>
		</tr>
		<%
		List<Registration> list = (ArrayList<Registration>) request.getAttribute("list");
		if (list != null) {
			for (Registration r : list) {
		%>
		<tr style="color: black; background-color: white; text-align: center;">
			<td><%=r.getName()%></td>
			<td><%=r.getMailId()%></td>
			<td><%=r.getphoneNumber()%></td>
			<td><input type="hidden" name="name" value="<%=r.getName()%>">
				<a href="Update.html?editMailId=<%=r.getMailId()%>">
					<button type="button"
						style="border-color: purple; background-color: white">Update</button>
			</a></td>
			<td><form action="DeleteUser" method="get">
					<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="delete" value="<%=r.getName()%>">
					<button type="submit"
						style="border-color: purple; background-color: white"
						title="delete">Delete</button>
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<div style="margin-left: 100px;">
	<form action="RegistrationSession" method="get">
		<input type="hidden" name="action" value="logout"> <input
			type="hidden" name="logout">
		<button type="submit"
			style="border-color: purple; background-color: white" title="logout">Logout</button>
	</form>
	</div>
</body>
</html>
