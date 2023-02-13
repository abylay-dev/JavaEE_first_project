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
</head>
<body>
<form action="add" method="post">
    <input name="model" placeholder="Model">
    <br>
    <input name="count" placeholder="Count" type="number">
    <br>
    <input name="price" placeholder="Price" type="number">
    <br>
    <button type="submit">ADD</button>
</form>
</body>
</html>
