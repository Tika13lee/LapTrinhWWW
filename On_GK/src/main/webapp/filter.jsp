<%@ page import="vn.edu.iuh.fit.backend.data.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 10/27/2024
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>

<% List<Account> ds = (List<Account>) request.getAttribute("listAcc"); %>
<form method="get" action="./account">
    <select name="select">
        <option value="balance">Balance</option>
        <option value="username">Username</option>
    </select>
    <br>
    <br>
    <label>
        Input:
        <input name="input" type="text">
    </label>
    <input type="submit" value="filter" name="action">
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Delete</th>
    </tr>
    <% if (ds != null) {
        for (Account account : ds) { %>
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
    </tr>
    <% }
    } %>
</table>

</body>
</html>
