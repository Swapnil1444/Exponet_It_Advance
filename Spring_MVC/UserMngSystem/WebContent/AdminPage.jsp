
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
        ${allUser}
    </div>

</div>

</body>
</html>
