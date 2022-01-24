<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New SubService</h1>
<form:form action="submitSaveSubService" modelAttribute="subServiceDto" method="post">
   <%-- <p>${subServiceDto.mainServiceName}</p>--%>
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>basePrice : </td>
            <td><form:input path="basePrice"/></td>
        </tr>
        <tr>
            <td>description : </td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
