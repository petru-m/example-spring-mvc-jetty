
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2>Push Data!</h2></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <h3></h3>
      </td>
    </tr>
    <tr>
      <td>Channel:</td>
      <td>${pushForm.name}</td>
    </tr>
    <tr>
      <td>Message:</td>
      <td>${pushForm.email}</td>
    </tr>


  </table>
</div>
</body>
</html>
