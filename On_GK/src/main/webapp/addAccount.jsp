<%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 10/26/2024
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Account</title>
</head>
<body>
    <h1>Add Account</h1>
    <form action="./account" method="post">
        <input type="text" name="username"/>
        <input type="password" name="password"/>
        <input type="submit" value="add" name="action"/>
    </form>
</body>
</html>
