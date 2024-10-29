<%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 10/27/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update </title>
</head>
<body>

<form action="./account" method="post">
    <input value="<%= request.getAttribute("id")%>" name="id" readonly>
    <label>
        useraname:
        <input type="text" name="username" value=""> />
    </label>
    <label>
        password:
        <input type="text" name="password" value="" />
    </label>
    <input type="submit" value="update" name="action"/>
</form>

</body>
</html>
