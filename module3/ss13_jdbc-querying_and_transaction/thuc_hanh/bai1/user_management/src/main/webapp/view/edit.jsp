<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/28/2022
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="/users?action=edit" method="post">
    <table>
        <input type="text" name="id" value="${user.id}" style="visibility: hidden">
        <tr>
            <td><%--@declare id="name"--%><label for="name">Name: </label></td>
            <td><input type="text" value="${user.name}" name="name"></td>
        </tr>
        <tr>
            <td><%--@declare id="email"--%><label for="email">Email: </label></td>
            <td>
                <input type="text" value="${user.email}" name="email">
            </td>
        </tr>

        <tr>
            <td><%--@declare id="country"--%><label for="country">Country: </label></td>
            <td>
                <input type="text" value="${user.email}" name="country">
            </td>
        </tr>
        <tr>
            <td><a href="/users">Cancel</a></td>
            <td><input type="submit" value="Edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
