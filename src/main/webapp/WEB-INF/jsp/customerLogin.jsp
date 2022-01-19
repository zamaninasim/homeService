<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@taglib
        uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Login Form</title>
</head>
<body>
<form:form name="submitForm" method="POST" action="/submitCustomerLogin">
    <div align="center">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="email" name="emailAddress" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
        <div style="color: red">${error}</div>
    </div>
</form:form>
<br>
<a align="center" href="/customerRegister">Register</a>
</body>
</html>
<%--<html>
<head>
    <title>customerLogin</title>

</head>
<body>
<div>
    <h2>Customer Login</h2>
    <form action="/customerLogin">
        <p><input type="email" placeholder="Email" name="email"></p>
        <p><input type="password" placeholder="Password" name="password"></p>
        <p><input type="submit" value="Login"></p>
    </form>
</div>
</body>
</html>--%>
