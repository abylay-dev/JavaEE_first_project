<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 13.02.2023
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p><%= request.getAttribute("fio") %></p>--%>

<h1>DETAILS.JSP</h1>
<h1><%=request.getParameter("fullname")%></h1>
<a href="/">Home</a>
</body>
</html>
