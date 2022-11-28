<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/31/2022
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"--%>
<%--            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"--%>
<%--            crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.0\css\bootstrap.min.css">
</head>
<body>
<div style="display: flex;justify-content: space-between;margin-top: 20px">
    <a style="height: 34px;" class="btn btn-info" href="/products?action=create">+Add new Product</a>
    <div>
        <form action="products?action=search" class="d-flex" role="search" method="post">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchInput">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</div>
<table style="text-align: center" id="myTable" class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="products" items="${products}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${products.name}</td>
            <td>${products.price}</td>
            <td>${products.quantity}</td>
            <td>${products.color}</td>
            <c:forEach var="categorys" items="${categorys}">
                <c:if test="${categorys.id==products.category}">
                    <td>${categorys.name}</td>
                </c:if>
            </c:forEach>
            <td><a class="btn btn-primary" href="/products?action=create&id=${products.id}">Edit</a>
                <button onclick="deleteInfor('${products.id}','${products.name}')" type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="products?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="deleteId" id="idDelete">
                    <span>Do you wan delete <span id="nameDelete"> </span> </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Ok</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="webjars\bootstrap\5.2.0\js\bootstrap.bundle.min.js"></script>
</body>
<script >
    function deleteInfor(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;
    }

    $(document).ready(function () {
        $('#myTable').DataTable();
    });
</script>
</html>
