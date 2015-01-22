

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <form:form action="push" method="post" commandName="pushForm" >
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2>Spring MVC Form Demo - Push Notification</h2></td>
      </tr>
      <tr>
        <td>Channel:</td>
        <td><form:input path="name" /></td>
      </tr>

      <tr>
        <td>Message:</td>
        <td><form:input path="email" /></td>
      </tr>


      <td colspan="2" align="center"><input type="submit" value="Send" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
