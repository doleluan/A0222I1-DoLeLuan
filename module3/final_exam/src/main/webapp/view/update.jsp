<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/14/2022
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.0\css\bootstrap.min.css">
</head>
<body>
<form action="/helloServlet?action=create" method="post">
    <table>
        <form action="/products?action=create" method="post">
            <table>
                <tr>
                    <td>
                        <label class="form-label">Mã Mặt Bằng: </label>
                    </td>
                    <td>
                        <input class="form-control" type="text" name="maMB">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label" >Diện Tích: </label>
                    </td>
                    <td>
                        <input class="form-control" type="number" required name="dientich">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label">Trạng Thái: </label>
                    </td>
                    <td>
                        <select name="trangThaiName" id="trangThaiId">
                            <c:forEach var="trangThai" items="${trangThai}">
                                <option value="${trangThai.id}">${trangThai.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label" >Tầng: </label>
                    </td>
                    <td>
                        <input class="form-control" type="number" name="tang">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label">Loại Văn Phòng: </label>
                    </td>
                    <td>
                        <select name="vanPhongName" id="vanPhongId">
                            <c:forEach var="vanPhong" items="${vanPhong}">
                                <option value="${vanPhong.id}">${vanPhong.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label">Giá Cho Thuê: </label>
                    </td>
                    <td>
                        <input class="form-control" type="number" name="giaChoThue">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label">Ngày Bắt Đầu: </label>
                    </td>
                    <td>
                        <input class="form-control" type="text" name="ngayBatDau">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label">Ngày Kết Thúc: </label>
                    </td>
                    <td>
                        <input class="form-control" type="text" name="ngayKetThuc">
                    </td>
                </tr>
                <tr>
                    <td><a class="btn btn-danger" href="/helloServlet">Cancel</a></td>
                    <td><input class="form-control btn btn-primary" type="submit" value="Ok"></td>
                </tr>
            </table>
        </form>
<%--        <script src="webjars\bootstrap\5.2.0\js\bootstrap.bundle.min.js">--%>
<%--        </script>--%>
</body>
</html>
