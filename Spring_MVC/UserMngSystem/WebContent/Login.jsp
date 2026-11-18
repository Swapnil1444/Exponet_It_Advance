
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #eef2f7;
	margin: 0;
}

.container {
	width: 350px;
	margin: 100px auto;
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px #ccc;
}

h2 {
	text-align: center;
	color: #2563eb;
	margin-bottom: 25px;
}

label {
	display: block;
	margin-bottom: 8px;
	color: #333;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	width: 100%;
	padding: 12px;
	background-color: #2563eb;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #1d4ed8;
}

p {
	text-align: center;
	color: #666;
}

a {
	color: #2563eb;
	text-decoration: none;
}
</style>

</head>

<body>

	<div class="container">

		<h2>User Login</h2>

		<form action="login">

			<label>Username</label> <input type="text" name="username"
				placeholder="Enter Username" required> <label>Password</label>
			<input type="password" name="password" placeholder="Enter Password"
				required>

			<button type="submit">Login Account</button>

		</form>

		<p>
			Don't have an account? <a href="SignUp.jsp">Sign Up</a>
		</p>

	</div>

</body>
</html>
