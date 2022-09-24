<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/23/2022
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculater</title>
  </head>
  <body>
  <h1>Caculater</h1>

  <form action="/add" method="post">
    <input type="number" name="a" id="a">
    <input type="number" name="b" id="b">
    <input type="text" id="operator" hidden name="operatorName">
    <p>${erro}</p>
    <p>${mess}</p>
    <pre></pre>
    <input onclick="document.getElementById('operator').value='+'" type="submit" value="Addition(+)">
    <input onclick="document.getElementById('operator').value='-'" type="submit" value="Subtraction(-)">
    <input onclick="document.getElementById('operator').value='*'" type="submit" value="Multiplication(*)">
    <input onclick="document.getElementById('operator').value='/'" type="submit"value="Division">
  </form>
  <h1>${result}</h1>
  </body>
</html>
