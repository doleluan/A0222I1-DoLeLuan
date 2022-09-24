<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/21/2022
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  </head>
  <body>
  <form action="/translate" method="post">
    <label for="">English</label>
    <input type="text" name="englishText">
    <input type="submit">
  </form>
  <c:if   test="${vnText!=null}">
    <h1> <span>${vnText}</span></h1>
  </c:if>
  </body>
</html>
