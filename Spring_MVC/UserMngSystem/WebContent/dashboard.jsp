
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
    padding: 18px 30px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header h1 {
    margin: 0;
    font-size: 25px;
}

/* Logout */
.logout {
    color: white;
    text-decoration: none;
    background-color: #dc2626;
    padding: 10px 18px;
    border-radius: 5px;
    font-size: 14px;
}

.logout:hover {
    background-color: #b91c1c;
}

/* Container */
.container {
    width: 90%;
    margin: 40px auto;
    background-color: white;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 2px 10px #ccc;
}

h2 {
    color: #1e293b;
    margin-top: 0;
    border-bottom: 2px solid #2563eb;
    padding-bottom: 12px;
}

h3 {
    color: #334155;
    margin-bottom: 20px;
}

/* Table */
.employee-info {
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
    min-width: 750px;
}

th {
    background-color: #2563eb;
    color: white;
    padding: 14px 10px;
    font-size: 14px;
}

td {
    padding: 12px 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
    color: #334155;
    font-size: 14px;
}

tr:hover {
    background-color: #f1f5f9;
}

/* Buttons */
.btn {
    display: inline-block;
    padding: 8px 15px;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 13px;
}

.edit {
    background-color: #16a34a;
}

.edit:hover {
    background-color: #15803d;
}

.delete {
    background-color: #dc2626;
}

.delete:hover {
    background-color: #b91c1c;
}

/* Footer */
.footer {
    text-align: center;
    color: #64748b;
    padding: 20px;
    font-size: 13px;
}

/* Responsive */
@media(max-width: 768px) {
    .container {
        width: 95%;
        padding: 15px;
    }

    .header h1 {
        font-size: 19px;
    }
}
</style>

</head>

<body>

    <!-- Header -->
    <div class="header">
        <h1>User Management System</h1>
        <a href="Login.jsp" class="logout">Logout</a>
    </div>

    <!-- Main Container -->
    <div class="container">

        <h2>Admin Dashboard</h2>

        <h3>All User Information</h3>

        <div class="employee-info">

            <table>

                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>CONTACT NO</th>
                    <th>EMAIL</th>
                    <th>AGE</th>
                    <th>USERNAME</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>

                <%
                    List<User> users =
                        (List<User>) request.getAttribute("allUser");

                    if (users != null && !users.isEmpty()) {

                        for (User user : users) {
                %>

                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getContectNo()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getAge()%></td>
                    <td><%=user.getUsername()%></td>

                    <td>
                        <a href="edit?id=<%=user.getId()%>"
                           class="btn edit">Edit</a>
                    </td>

                    <td>
                        <a href="delete?id=<%=user.getId()%>"
                           class="btn delete"
                           onclick="return confirm('Are you sure you want to delete this user?');">
                           Delete
                        </a>
                    </td>
                </tr>

                <%
                        }
                    } else {
                %>

                <tr>
                    <td colspan="8">No User Found!</td>
                </tr>

                <%
                    }
                %>

            </table>

        </div>

    </div>

    <!-- Footer -->
    <div class="footer">
        © 2026 User Management System
    </div>

</body>
</html>
```