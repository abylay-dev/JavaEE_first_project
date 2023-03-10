<%@ page import="model.Laptop" %>
<%@ page import="model.Country" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 15.02.2023
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<br>

<%
    Laptop laptop = (Laptop) request.getAttribute("laptop");
%>

<div class="container" style="width: 50%">
    <form action="details" method="post">
        <div class="mb-3 mt-5">
            <label for="modelName" class="form-label">Model</label>
            <input name="model" type="text" class="form-control" id="modelName"
                   placeholder="Model" value="<%=laptop.getModel()%>">
        </div>
        <div class="mb-3">
            <label for="count" class="form-label">Count</label>
            <input name="count" class="form-control" id="count" placeholder="5"/>
        </div>
        <div class="mb-4">
            <label for="price" class="form-label">Price</label>
            <input name="price" class="form-control" id="price" placeholder="50000"/>
        </div>
        <select class="form-select" aria-label="Default select example">
            <% for (Country c : (List<Country>) request.getAttribute("countries")) {
                if (c.getCode().equals(laptop.getCountry().getCode())) { %>
            <option selected name="country_code" value="<%=c.getCode()%>"><%=c.getName()%>
            </option>
            <% } else {
            %>
            <option name="country_code" value="<%=c.getCode()%>"><%=c.getName()%>
            </option>
            <%
                    }
                }
            %>
        </select>

        <input name="id" hidden value="<%=laptop.getId()%>"/>

        <input class="btn btn-primary" type="submit" value="ADD">
    </form>
    <!-- TODO edit COUNT, PRICE, BUTTON ?? ?????????????????? ???????????? ?? ProductDetailsServlet ?????????? ???? ???????????????????? ???????????? -->
</div>


</body>
</html>
