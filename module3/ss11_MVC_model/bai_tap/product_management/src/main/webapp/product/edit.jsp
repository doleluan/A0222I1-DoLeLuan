<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/23/2022
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<form action="/productServlet?action=edit&id=${product.id}" method="post">
    <%--@declare id="name"--%><%--@declare id="price"--%><%--@declare id="manufactor"--%>
        <div>
            <a href="/productServlet">Quay về</a>
        </div>
        <c:if test="${mess!=null}">
            <p style="color: red">${mess}</p>
        </c:if>
        <label for="name">Name:</label>
         <input type="text" name="name" value="${product.name}">
        <br>
        <label for="price">Price:</label>
        <input type="text" name="price" value="${product.price}">
        <br>
        <label for="manufactor">Manufactor:</label>
        <input type="text" name="manufactor" value="${product.manufactor}">
        <br>
        <input type="submit" value="Update">
</form>
</body>
</html>
