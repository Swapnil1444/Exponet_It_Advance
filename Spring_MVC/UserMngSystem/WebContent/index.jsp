
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management System</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #eef2f7;
	margin: 0;
}

/* Header */
.header {
	background-color: #2563eb;
	color: white;
	padding: 20px;
	text-align: center;
}

/* Main Content */
.container {
	width: 350px;
	margin: 100px auto;
	background: white;
	padding: 35px;
	text-align: center;
	border-radius: 10px;
	box-shadow: 0 2px 10px #ccc;
}

h2 {
	color: #333;
}

p {
	color: #666;
	margin-bottom: 30px;
}

/* Buttons */
a {
	display: block;
	padding: 12px;
	margin: 15px 0;
	text-decoration: none;
	color: white;
	background-color: #2563eb;
	border-radius: 5px;
}

a:hover {
	background-color: #1d4ed8;
}

/* Footer */
.footer {
	text-align: center;
	color: #777;
	padding: 15px;
}
</style>

</head>

<body>

	<div class="header">
		<h1>User Management System</h1>
	</div>

	<div class="container">

		<h2>Welcome!</h2>

		<p>Manage your User easily and efficiently.</p>

		<a href="Login.jsp">Login</a> <a href="SignUp.jsp">Sign Up</a>

	</div>

	<div class="footer">
		<p>© 2026 User Management System</p>
	</div>

</body>
</html>
