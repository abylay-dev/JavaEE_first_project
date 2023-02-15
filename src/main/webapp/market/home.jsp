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

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Market</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add">Add product</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Model</th>
            <th scope="col">Count</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>

        <%
            List<Laptop> laptops = (List<Laptop>) request.getAttribute("nouts");
            for (Laptop l : laptops) {
        %>
        <tr>
            <th scope="row"><%=l.getId()%>
            </th>
            <td><%=l.getModel()%>
            </td>
            <td><%=l.getCount()%>
            </td>
            <td><%=l.getPrice() + " KZT"%>
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
</div>
</body>
</html>
