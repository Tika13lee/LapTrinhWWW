<%@ page import="vn.edu.iuh.fit.demo1.backend.data.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.demo1.frontend.models.AccountModel" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/9/2024
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Account</h1>

<form action="./accountController" method="post">
    <label>
        id
        <input type="text" name="id">
    </label>
    <br/>
    <br/>
    <label>
        Username
        <input type="text" name="username">
    </label>
    <br/>
    <br/>
    <label>
        Password
        <input type="text" name="password">
    </label>
    <br/>
    <br/>
    <input type="submit" name="action" value="ADD">
</form>

<br/>
<br/>
<form action="./accountController" method="get">
    <select name="select">
        <option value="username">username</option>
        <option value="id">id</option>
    </select>
    <input type="text" name="search">
    <input type="submit" name="action" value="Search">
</form>

<br/>
<br/>

<% List<Account> ds = request.getAttribute("accounts") != null ? (List<Account>) request.getAttribute("accounts") : new AccountModel().getAccounts(); %>
<table border="1">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>delete</th>
    </tr>
    <% if (ds != null) {
        for (Account a : ds) {%>
    <tr>
        <td><%= a.getId()%>
        </td>
        <td><%= a.getUsername()%>
        </td>
        <td><%= a.getPassword()%>
        </td>
        <td>
            <form action="./accountController" method="post">
                <input type="hidden" name="id" value="<%=a.getId()%>">
                <input type="submit" name="action" value="Delete">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>


</body>
</html>
