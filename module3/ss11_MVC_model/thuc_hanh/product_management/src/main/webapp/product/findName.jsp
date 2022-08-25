<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<style>
    table{
        width: 90%;
        margin: 0 auto;
        border-collapse: collapse;
        text-align: center;
    }
    td,th{
        border: 1px solid #000;
        padding: 20px 0;
    }
    a{
        text-decoration: none;
    }
</style>
<body>
<h1>Product</h1>
<p>
    <a href="/productServlet">Quay ve trang list</a>
    <br>
</p>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Manufactor</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.manufactor}</td>
            <td><a href="/productServlet?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>