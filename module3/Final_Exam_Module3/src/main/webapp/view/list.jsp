<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/15/2022
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.0\css\bootstrap.min.css">
</head>
<body>
<div style="display: flex;justify-content: space-around;align-items: center">
    <a class="btn btn-info" href="/helloServlet?action=create">Add New</a>
    <div style="width: 200px">
        <form action="helloServlet?action=search" class="d-flex" role="search" method="post">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchInput">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <form action="helloServlet?action=sort" class="d-flex" role="search" method="post">
        <button class="btn btn-outline-success" type="submit">Sort</button>
    </form>
</div>
<table id="myTable" class="table table-striped">
        <thead>
        <tr>
            <th>Mã MB</th>
            <th>Diện Tích</th>
            <th>Trạng Thái</th>
            <th>Tầng</th>
            <th>Loại Văn Phòng</th>
            <th>Giá Cho Thuê</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Delete</th>
        </tr>
        </thead>
    <tbody>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    a
                </td>
                <td>
                    <button onclick="deleteInfor('1','a')" type="button" class="btn btn-primary"
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
        <form action="helloServlet?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="deleteId" id="idDelete">
                    <span>Do you wan delete <span id="nameDelete"></span> </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Ok</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="webjars\bootstrap\5.2.0\js\bootstrap.bundle.min.js" ></script>
</body>
<script >
    function deleteInfor(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;
    }
</script>
</html>
