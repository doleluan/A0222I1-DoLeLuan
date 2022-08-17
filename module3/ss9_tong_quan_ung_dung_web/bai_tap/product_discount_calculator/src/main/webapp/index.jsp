<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/18/2022
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculater</title>
  </head>
  <body>
  <form action="/caculater" method="post">
    <labe>Product Description: </labe>
    <br>
    <input type="text" name="productDes" placeholder="Product Description"><br>
    <labe>List Price: </labe>
    <br>
    <input type="text" name="productPrice" placeholder="Product Price"><br>
    <labe>Discount Percent: </labe>
    <br>
    <input type="text" name="discountPercent" placeholder="Product Price"><br>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  </body>
</html>
