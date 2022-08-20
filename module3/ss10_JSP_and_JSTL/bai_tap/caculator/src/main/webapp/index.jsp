<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 8/19/2022
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Caculator</h1>
  <form action="/caculator" method="post">
    <%--@declare id="firstoperand"--%>
      <%--@declare id="secondoperand"--%>
      <fieldset>
      <legend>Caculator</legend>
    <label for="firstOperand" >First operand: </label>
    <input name="firstOperand" type="text">
    <br>
    <label>Operator: </label>
    <select name="operator" id="cars">
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/">Division</option>
    </select>
    <br>
      <label for="secondOperand">Second operand: </label>
      <input name="secondOperand" type="text">
      <br>
      <input type="submit" value="Calculate">
      </fieldset>
  </form>
  </body>
</html>
