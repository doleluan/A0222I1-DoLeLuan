<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/5/2022
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</head>
<body>
<form action="/products?action=create" method="post">
    <table>
        <input type="number" hidden value="${id}" name="id" value="${product.id}">
            <tr>
                <td>
                    <label class="form-label" for="">Product Name: </label>
                </td>
                <td>
                    <input class="form-control" type="text" name="name"  value="${product.name}">
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td><c:if test="${error!=null}">
                    <span style="color:red">${error.get("name")}</span>
                </c:if></td>
            </tr>
        <tr>
            <td>
                <label class="form-label"  for="">Price: </label>
            </td>
            <td>
                <input class="form-control" type="number" required name="price" value="${product.price}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <c:if test="${error!=null}">
                    <span style="color:#ff0000">${error.get("price")}</span>
                </c:if>
                <c:if test="${errorPrice!=null}">${errorPrice}</c:if>
            </td>

        </tr>
        <tr>
            <td>
                <label class="form-label" for="">Quantity: </label>
            </td>
            <td>
                <input class="form-control" required type="number" name="quantity" value="${product.quantity}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <c:if test="${error!=null}">
                    <span style="color:red">${error.get("quantity")}</span>
                </c:if>
                <c:if test="${errorQuantity!=null}">${errorQuantity}</c:if>
            </td>

        </tr>
        <tr>
            <td>
                <label class="form-label" for="">Color: </label>
            </td>
            <td>
                <input class="form-control" type="text" name="color" value="${product.color}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <c:if test="${error!=null}">
                    <span style="color:red">${error.get("color")}</span>
                </c:if>
            </td>

        </tr>
        <tr>
            <td>
                <label class="form-label" for="">Description: </label>
            </td>
            <td>
                <input class="form-control" type="text" name="des" value="${product.description}">
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <c:if test="${error!=null}">
                    <span style="color:red">${error.get("des")}</span>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <label class="form-label" for="">Category: </label>
            </td>
            <td>
                    <select name="categoryName" id="categoryId">
                        <c:forEach var="categoryList" items="${categoryList}">
                        <option value="${categoryList.id}">${categoryList.name}</option>
                        </c:forEach>
                    </select>
            </td>
        </tr>
        <tr>
            <td><a class="btn btn-danger" href="/products">Cancel</a></td>
            <td><input class="form-control btn btn-primary" type="submit" value="Ok"></td>
        </tr>
    </table>
</form>
</body>
</html>
