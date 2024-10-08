<%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 9/30/2024
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="../account" method="post">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="hidden" name="action" value="add_account">
        <input type="submit" value="add">
    </form>
</body>
</html>
