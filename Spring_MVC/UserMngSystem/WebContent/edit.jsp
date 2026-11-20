
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>

<style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    background-color: #eef2f7;
    margin: 0;
}

/* Header */
.header {
    background-color: #2563eb;
    color: white;
    padding: 18px;
    text-align: center;
}

.header h1 {
    margin: 0;
    font-size: 25px;
}

/* Form Container */
.container {
    width: 420px;
    margin: 40px auto;
    background-color: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 10px #ccc;
}

h2 {
    text-align: center;
    color: #1e293b;
    margin-top: 0;
    margin-bottom: 25px;
    border-bottom: 2px solid #2563eb;
    padding-bottom: 12px;
}

/* Form */
label {
    display: block;
    margin-bottom: 7px;
    color: #334155;
    font-size: 14px;
    font-weight: bold;
}

input {
    width: 100%;
    padding: 11px;
    margin-bottom: 18px;
    border: 1px solid #cbd5e1;
    border-radius: 5px;
    outline: none;
    font-size: 14px;
}

input:focus {
    border-color: #2563eb;
}

/* Update Button */
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

/* Back Link */
.back {
    display: block;
    text-align: center;
    margin-top: 18px;
    color: #2563eb;
    text-decoration: none;
    font-size: 14px;
}

.back:hover {
    text-decoration: underline;
}

/* Responsive */
@media(max-width: 480px) {
    .container {
        width: 90%;
        padding: 22px;
    }
}

/* Footer */
.footer {
    text-align: center;
    color: #64748b;
    padding: 15px;
    font-size: 13px;
}
</style>

</head>

<body>

    <!-- Header -->
    <div class="header">
        <h1>User Management System</h1>
    </div>

    <%
        User user = (User) request.getAttribute("user");
    %>

    <!-- Edit Form -->
    <div class="container">

        <h2>Edit User</h2>

        <form action="update" method="post">

            <input name="id" type="hidden"
                   value="<%=user.getId()%>">

            <label>Name</label>
            <input name="name" type="text"
                   value="<%=user.getName()%>" required>

            <label>Email</label>
            <input name="email" type="email"
                   value="<%=user.getEmail()%>" required>

            <label>Contact No</label>
            <input name="contectNo" type="text"
                   value="<%=user.getContectNo()%>" required>

            <label>Age</label>
            <input name="age" type="number"
                   value="<%=user.getAge()%>" required>

            <label>Username</label>
            <input name="username" type="text"
                   value="<%=user.getUsername()%>" required>

            <label>Password</label>
            <input name="password" type="password"
                   value="<%=user.getPassword()%>" required>

            <button type="submit">Update User</button>

        </form>

        <a href="${pageContext.request.contextPath}/dashboard" class="back">Back to Dashboard</a>

    </div>

    <!-- Footer -->
    <div class="footer">
        © 2026 User Management System
    </div>

</body>
</html>
```