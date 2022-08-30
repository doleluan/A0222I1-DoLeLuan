<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/28/2022
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<form action="/users?action=create" method="post">
    <table>
        <tr>
            <td><%--@declare id="name"--%><label for="name">Name: </label></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>
                <%--@declare id="email"--%><label for="email">Email: </label>
            </td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>
                <%--@declare id="country"--%><label for="country">Country: </label>
            </td>
            <td>
                <input type="text" name="country">
            </td>
        </tr>
        <tr>
            <td><a href="/users">Cancel</a></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
</body>
</html>
