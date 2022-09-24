<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/21/2022
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/caculater" method="post">
    <label for="">USD: </label>
    <input type="number" name="usd">
    <input type="submit">
</form>
    <h1>VNĐ: </h1>
    <c:if   test="${result!=null}">
        <h1>VNĐ:  <span>${result}</span></h1>
    </c:if>
</body>
</html>
