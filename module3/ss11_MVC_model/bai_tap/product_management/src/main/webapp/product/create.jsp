<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/22/2022
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
    <h1>Create Product</h1>
    <a href="/productServlet">Quay lai trang list</a>
    <c:if test="${mess!=null}">
        <p style="color: red">${mess}</p>
    </c:if>
    <form action="/productServlet?action=create" method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name"></td>
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("name")}</span>
                    </c:if>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="number" name="price" id="price"></td>
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("price")}</span>
                    </c:if>
                </tr>
                <tr>
                    <td>Manufactor: </td>
                    <td><input type="text" name="manufactor" id="manufactor"></td>
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("manufactor")}</span>
                    </c:if>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
