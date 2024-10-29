<%@ page import="vn.edu.iuh.fit.backend.data.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 10/26/2024
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Account</title>
</head>
<body>
<% List<Account> ds = (List<Account>) request.getAttribute("accountList"); %>
<h1>List Account</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <% for (Account account : ds) { %>
    <tr>
        <td><%= account.getId() %>
        </td>
        <td><%= account.getUsername() %>
        </td>
        <td><%= account.getPassword() %>
        </td>
        <td>
            <form action="./account" method="post">
                <input type="hidden" name="id" value="<%= account.getId() %>">
                <input type="submit" value="delete" name="action">
            </form>
        </td>
        <td>
            <form action="./account" method="post">
                <input type="hidden" name="id" value="<%= account.getId() %>">
                <input type="submit" value="switchUpdate" name="action">
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
