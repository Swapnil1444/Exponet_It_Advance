
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Sign Up</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #eef2f7;
    margin: 0;
}

.container {
    width: 350px;
    margin: 50px auto;
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
    margin-bottom: 7px;
    color: #333;
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 18px;
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
    font-size: 16px;
    cursor: pointer;
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

    <h2>Create Account</h2>

    <form action="signup" method="post">

        <label>Full Name</label>
        <input type="text" name="name"
            placeholder="Enter Full Name" required>

        <label>Username</label>
        <input type="text" name="username"
            placeholder="Enter Username" required>

        <label>Email</label>
        <input type="email" name="email"
            placeholder="Enter Email" required>

        <label>Password</label>
        <input type="password" name="password"
            placeholder="Enter Password" required>

        <button type="submit">Create Account</button>

    </form>

    <p>Already have an account? <a href="Login.jsp">Login</a></p>

</div>

</body>
</html>
