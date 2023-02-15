<%--
  Created by IntelliJ IDEA.
  User: noname
  Date: 13.02.2023
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD product</title>
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

<div class="container" style="width: 50%">
    <form action="add" method="post">
        <div class="mb-3 mt-5">
            <label for="modelName" class="form-label">Model</label>
            <input name="model" type="text" class="form-control" id="modelName"
                   placeholder="Model">
        </div>
        <div class="mb-3">
            <label for="count" class="form-label">Count</label>
            <input name="count" class="form-control" id="count" placeholder="5"/>
        </div>
        <div class="mb-4">
            <label for="price" class="form-label">Price</label>
            <input name="price" class="form-control" id="price" placeholder="50000"/>
        </div>
        <input class="btn btn-primary" type="submit" value="ADD">
    </form>
</div>

</body>
</html>
