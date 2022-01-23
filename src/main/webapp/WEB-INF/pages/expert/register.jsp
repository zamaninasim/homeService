<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="resources/css/registerStyle.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container register">

    <%--left part of page--%>
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="resources/image/service.png" alt=""/>
            <h3>Home Service</h3>
            <p>We are your partner until the end of the service ...</p>
            <form:form method="GET" action="/ExpertLogin">
                <input type="submit" name="" value="Login"/><br/>
            </form:form>
        </div>

        <div class="col-md-9 register-right">
            <div class="btn-group mt-5 mx-5">
                <a href="<c:url value="/customerHome"/>" class="btn btn-outline-primary">customer</a>
                <a href="<c:url value="/expertHome"/>" class="btn btn-outline-primary active">expert</a>
            </div>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="customer" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Register as a Customer</h3>
                    <form:form enctype="multipart/form-data" action="/expertRegister" modelAttribute="expertDto">
                        <div class="row register-form">
                            <div class="col-md-12" align="center">
                                <p class="error">${error}</p>
                                <table>
                                    <tr>
                                        <td><form:input path="firstname" cssClass="form-control"
                                                        placeholder="First Name *"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:errors path="firstname" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="lastname" cssClass="form-control"
                                                        placeholder="Last Name *"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:errors path="lastname" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:input path="emailAddress" cssClass="form-control"
                                                        placeholder="Your Email *"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:errors path="emailAddress" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:password path="password" cssClass="form-control"
                                                           placeholder="Password *"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:errors path="password" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Upload Profile Image :</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="file" id="image" name="image">
                                        </td>
                                    </tr>
                                </table>
                                <form:button id="btnRegister" name="register">Register</form:button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/register.js"></script>
</body>
</html>
