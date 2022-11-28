<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/15/2022
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.2.0\css\bootstrap.min.css">
</head>
<body>
<form action="/helloServlet?action=create" method="post">
        <table>
            <tr>
                <td>
                    <label class="form-label">Mã Mặt Bằng: </label>
                </td>
                <td>
                    <input class="form-control" type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="form-label">Mã Mặt Bằng: </label>
                </td>
                <td>
                    <input class="form-control" type="text" name="maMB">
                </td>
            </tr>
            <tr>
                <td><a class="btn btn-danger" href="/helloServlet">Cancel</a></td>
                <td><input class="form-control btn btn-primary" type="submit" value="Ok"></td>
            </tr>
        </table>
</form>
<script src="webjars\bootstrap\5.2.0\js\bootstrap.bundle.min.js" ></script>
</body>
</html>
