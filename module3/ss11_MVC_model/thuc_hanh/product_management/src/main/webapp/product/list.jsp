<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

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
<h1>Customers</h1>
<p>
    <a href="/productServlet?action=create">Create new customer</a>
    <br>
<form action="/productServlet?action=findName" method="post">
    <input type="text" name="namefind">
    <input type="submit" value="Find">
</form>
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
                <td>
<%--                    <button type="button" onclick="deleteInfo('${product.id}','${product.name}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--                        <a href="/productServlet?action=delete&id=${product.id}">Delete</a>--%>
<%--                    </button>--%>
    <a href="/productServlet?action=delete&id=${product.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/student" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden name="deleteId" id="deleteId">
                    <input hidden name="action" value="delete">
                    <span>Bạn có muốn xoá sinh viên </span><span id="deleteName"></span><span> Không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function deleteInfo(id,name) {
        document.getElementById("deleteId").value=id;
        document.getElementById("deleteName").innerText=name;
    }
</script>
</body>
</html>
