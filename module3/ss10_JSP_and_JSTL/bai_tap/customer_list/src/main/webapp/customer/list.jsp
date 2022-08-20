<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/19/2022
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>Danh sách khách hàng</h1>
        <table>
            <tr>
                <th>STT</th>
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>Địa Chỉ</th>
                <th>Ảnh</th>
            </tr>
            <c:forEach var="customer" items="${customerList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getDateOfBirth()}</td>
                    <td>${customer.getAddress()}</td>
                    <td>
                        <img width="50px" height="50px" src="${customer.getPicture()}" alt="">
                    </td>
                </tr>
            </c:forEach>

        </table>
</body>
</html>
