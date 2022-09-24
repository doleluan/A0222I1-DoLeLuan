<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/23/2022
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Gia vị</title>
  </head>
  <body>
  <form action="/priceChoose" method="post">
  <input type="checkbox" name="choose" id="idLettuce" value="Lettuce">
    <label for="idLettuce">Lettuce</label>
      <input type="checkbox" name="choose" id="idTomato" value="Tomato">
      <label for="idTomato">Tomato</label>
      <input type="checkbox" name="choose" id="idMustard" value="Mustard">
      <label for="idMustard">Mustard</label>
      <input type="checkbox" name="choose" id="idSprouts" value="Sprouts">
      <label for="idSprouts">Sprouts</label>
      <input type="submit" value="Save">
  </form>
  </body>
</html>
