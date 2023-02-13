<%@ page import="java.util.List" %>
<%@ page import="model.Laptop" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 13.02.2023
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>

<a href="add">ADD PRODUCT</a>

<table>
    <thead>
    <tr>
        <td>Model</td>
        <td>Count</td>
        <td>Price</td>
    </tr>
    </thead>
    <tbody>
    <%
        List<Laptop> laptops = (List<Laptop>) request.getAttribute("nouts");
        for (Laptop l : laptops){
    %>
    <tr>
        <td><%=l.getModel()%></td>
        <td><%=l.getCount()%></td>
        <td><%=l.getPrice() + " KZT"%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
