
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
    background-color: #f1f5f9;
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
    font-size: 24px;
}

/* Logout Button */
.logout {
    background-color: #dc2626;
    color: white;
    padding: 10px 18px;
    text-decoration: none;
    border-radius: 5px;
    font-size: 14px;
}

.logout:hover {
    background-color: #b91c1c;
}

/* Main Container */
.container {
    width: 90%;
    margin: 40px auto;
    background-color: white;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 2px 10px #ddd;
}

h2 {
    color: #1e293b;
    margin-top: 0;
}

.subtitle {
    color: #64748b;
    margin-bottom: 25px;
}

/* Table */
.table-container {
    width: 100%;
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    min-width: 750px;
}

th {
    background-color: #2563eb;
    color: white;
    padding: 14px 10px;
    text-align: center;
    font-size: 14px;
}

td {
    padding: 13px 10px;
    text-align: center;
    border-bottom: 1px solid #e2e8f0;
    color: #334155;
    font-size: 14px;
}

tr:hover {
    background-color: #f8fafc;
}

/* Action Buttons */
.btn {
    display: inline-block;
    padding: 7px 14px;
    color: white;
    text-decoration: none;
    border-radius: 4px;
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

    .header {
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

    <!-- Main Content -->
    <div class="container">

        <h2>Admin Dashboard</h2>

        <p class="subtitle">Manage and view all registered users.</p>

        <div class="table-container">

            <table>

                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Contact No</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Username</th>
                    <th>Edit</th>
                    <th>Delete</th>
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
                    <td colspan="8">No users found.</td>
                </tr>

                <%
                    }
                %>

            </table>

        </div>

    </div>

    <!-- Footer -->
    <div class="footer">
        © 2026 User Management System. All Rights Reserved.
    </div>

</body>
</html>
```