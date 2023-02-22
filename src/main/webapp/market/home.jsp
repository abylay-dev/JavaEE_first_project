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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>

<%@include file="vendor/navbar.jsp"%>
<br>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Model</th>
            <th scope="col">Count</th>
            <th scope="col">Price</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>

        <%
            List<Laptop> laptops = (List<Laptop>) request.getAttribute("nouts");
            for (Laptop l : laptops) {
        %>
        <tr>
            <th scope="row"><%=l.getId()%></th>
            <td><%=l.getModel()%></td>
            <td><%=l.getCount()%></td>
            <td><%=l.getPrice() + " KZT"%></td>
            <td><a href="details?id=<%=l.getId()%>" type="button" class="btn btn-info">Edit</a></td>
            <td><a type="button" class="btn btn-danger">Delete</a></td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
</div>
</body>
</html>
