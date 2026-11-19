
<%@page import="org.omg.CORBA.Request"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #eef2f7;
	margin: 0;
}

.header {
	background-color: #2563eb;
	color: white;
	padding: 20px;
	text-align: center;
}

.container {
	width: 85%;
	margin: 40px auto;
	background-color: white;
	padding: 25px;
	border-radius: 8px;
	box-shadow: 0 2px 10px #ccc;
}

h2 {
	color: #333;
	border-bottom: 2px solid #2563eb;
	padding-bottom: 10px;
}

.employee-info {
	background-color: #f1f5f9;
	padding: 15px;
	border-radius: 5px;
	margin-top: 20px;
	color: #333;
}

.logout {
	float: right;
	color: white;
	text-decoration: none;
	background-color: #dc2626;
	padding: 10px 18px;
	border-radius: 5px;
}

.logout:hover {
	background-color: #b91c1c;
}
</style>

</head>

<body>

	<div class="header">
		<h1>User Management System</h1>
		<a href="Login.jsp" class="logout">Logout</a>
	</div>

	<div class="container">

		<h2>Admin Dashboard</h2>

		<h3>All User Information</h3>

		<div class="employee-info">

			<table border="5">

				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>CONTECT NO</th>
					<th>EMAIL</th>
					<th>AGE</th>
					<th>USERNAME</th>
					<th>PASSWORD</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<%
					for (User user : (List<User>) request.getAttribute("allUser")) {
				%>
				<tr>
				 <td><%=user.getId() %></td>
				 <td><%=user.getName() %></td>
				 <td><%=user.getContectNo() %></td>
				 <td><%=user.getEmail() %></td>
				 <td><%=user.getAge() %></td>
				 <td><%=user.getUsername() %></td>
				 <td><%=user.getPassword() %></td>
				 
				 <td> <a href="edit?id=<% user.getId();%>"><button style="outline-color: green;" >Edit</button></a></td>
				 <td> <a href="delete?id=<% user.getId();%>"><button style="outline-color:red;" >Delete</button></a></td>
				</tr>
				
				<%
					}
				%>
			</table>


		</div>

	</div>

</body>
</html>
