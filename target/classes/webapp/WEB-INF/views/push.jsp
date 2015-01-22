<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>



    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Push Notification</title>
</head>
<body>
<div align="center">
    <form:form action="push" method="post" commandName="userForm" >
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Spring MVC Form Demo - Push Notification</h2></td>
            </tr>
            <tr>
                <td>Channel :</td>
                <td><form:input path="channel" /></td>
            </tr>

            <tr>
                <td>Message:</td>
                <td><form:input path="message" /></td>
            </tr>

            </tr>
            <td colspan="2" align="center"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>