<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/13/2022
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.0\css\bootstrap.min.css">
</head>
<body>
<a class="btn btn-info" href="/helloServlet?action=create">Thêm Mặt Bằng</a>
<div>
    <form action="products?action=search" class="d-flex" role="search" method="post">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchInput">
        <button class="btn btn-outline-success" type="submit">Search</button>
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
                <c:forEach var="matBang" items="${matBang}">
                    <tr>
                        <td>${matBang.maMB}</td>
                        <td>${matBang.dienTich}</td>

                        <c:forEach var="trangThai" items="${trangThai}">
                            <c:if test="${matBang.maTrangThai==trangThai.id}">
                                <td>${trangThai.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${matBang.tang}</td>
                        <c:forEach var="vanPhong" items="${vanPhong}">
                            <c:if test="${matBang.maLoaiVanPhong==vanPhong.id}">
                                <td>${vanPhong.name}</td>
                            </c:if>
                        </c:forEach>
                        <td>${matBang.gia}</td>
                        <td>${matBang.ngayBatDau}</td>
                        <td>${matBang.ngayKetThuc}</td>
                        <td>
                            <button onclick="deleteInfor('${matBang.id}','${matBang.maMB}')" type="button" class="btn btn-primary"
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
    // $(document).ready(function () {
    //     $('#myTable').DataTable();
    // });
</script>
</html>
