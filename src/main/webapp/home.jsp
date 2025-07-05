<%--
  Created by IntelliJ IDEA.
  User: thidas
  Date: 05/07/2025
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>

<%
  if (session.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
  }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome to JTA Banking System</h1>
</body>
</html>
