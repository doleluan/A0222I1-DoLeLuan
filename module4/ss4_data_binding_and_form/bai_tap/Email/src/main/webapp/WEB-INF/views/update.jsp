<%--
  Created by IntelliJ IDEA.
  User: Luan
  Date: 9/30/2022
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Email</title>
  </head>
  <body>
  <form:form action="/save" method="post" modelAttribute="email">
    <form:input  path="id" type="hidden" value="${email.id}"  />
    <label for="">Languages</label>
    <form:select path="languages">
      <form:option value="">${email.languages}</form:option>
    <form:options items="${listLanguages}"></form:options>
    </form:select>
    <br>
    <label for="">Size</label>
    <form:input path="size" type="number" name="size" value="${email.size}"/>
    <br>
    <label for="">Filter</label>
    <form:checkbox path="filter" value="Enable spams filer"></form:checkbox>
    <br>
    <label for="">Signature</label>
    <form:textarea path="signature" value="${email.signature}"></form:textarea>
    <br>
    <button type="submit">OK</button>
  </form:form>
  </body>
</html>
