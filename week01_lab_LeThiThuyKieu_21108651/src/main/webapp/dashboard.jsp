<%@ page import="vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: LAPTOP
  Date: 9/10/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>Thông tin người dùng</h2>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null) {
    %>
    <p>Username: <span><%= account.getAccountId() %></span></p>
    <%--    <p>Role: <span><%= account.getRole() %></span></p>--%>
    <p>Fullname: <span><%= account.getFullName() %></span></p>
    <p>Email: <span><%= account.getEmail() %></span></p>
    <p>Phone: <span><%= account.getPhone() %></span></p>
    <p>Status: <span><%= account.getStatus() %></span></p>
    <%
        } else {
    %>
    <p>Không tìm thấy thông tin người dùng.</p>
    <%
        }
    %>
</div>
</body>
</html>
