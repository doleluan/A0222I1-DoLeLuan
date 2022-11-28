<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/27/2022
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Managerment</title>
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
</head>
<body>
        <div>
            <a href="/users?action=create">Thêm mới</a>
        </div>
        <div>
            <form action="/users?action=findByCountry" method="post">
                <input type="text" name="findCountry" placeholder="Find By Country">
                <input type="submit" value="Find">
            </form>
        </div>
        <div>
            <c:if test="${mess!=null}">
                <span style="color: red">${mess}</span>
            </c:if>
        </div>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="users" items="${userList}">
                <tr>
                    <td>${users.id}</td>
                    <td>${users.name}</td>
                    <td>${users.email}</td>
                    <td>${users.country}</td>
                    <td><a href="/users?action=edit&id=${users.id}">Edit</a></td>
                    <td><a href="/users?action=delete&id=${users.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="/users?action=sort" method="post">
            <input type="submit" value="Sort Name">
        </form>
</body>
</html>
