<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/30/2022
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table border="1">
            <tr>
                <th>Languaes</th>
                <th>Size</th>
                <th>Spams Filter</th>
                <th>Signature</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list.languages}</td>
                    <td>${list.size}</td>
                    <td>${list.filter}</td>
                    <td>${list.signature}</td>
                    <td><a href="/save?id=${list.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/save">Add New</a>
</body>
</html>
