<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Person Search Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/header.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/footer.css' />" rel="stylesheet"/>


</head>

<body>

<div class="generic-container">

    <div class="panel">
        <jsp:include page="header.jsp"/>
    </div>

    <div class="well lead">Details of Registration</div>
    <%--@elvariable id="registrationDetail" type="de.cosmicit.kvr.model.Registration"--%>
    <form:form method="GET" modelAttribute="registrationDetail" class="form-horizontal" action="/registration/deregister">
        <form:input type="hidden" path="id" id="id"/>

    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <h6 class="text-on-pannel text-primary"><strong class="text-uppercase"> Registration Details </strong></h6>


                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td>Current Address</td>
                        <td>${registrationDetail.currentAddress.street}&nbsp;
                                ${registrationDetail.currentAddress.houseNumber}&nbsp;
                                ${registrationDetail.currentAddress.city}&nbsp;
                                ${registrationDetail.currentAddress.zip}
                        </td>
                    </tr>
                    <tr>
                        <td>Previous Address</td>
                        <td>${registrationDetail.previousAddress.street}&nbsp;
                                ${registrationDetail.previousAddress.houseNumber}&nbsp;
                                ${registrationDetail.previousAddress.city}&nbsp;
                                ${registrationDetail.previousAddress.zip}
                        </td>
                    </tr>
                    <tr>
                        <td>Registration Date</td>
                        <td>${registrationDetail.registrationDate}</td>
                    </tr>
                    <tr>
                        <td>Creation Date</td>
                        <td>${registrationDetail.createdDate}</td>
                    </tr>
                    <tr>
                        <td>Created By</td>
                        <td>${registrationDetail.createdBy}</td>
                    </tr>
                    <tr>
                        <td>Modification Date</td>
                        <td>${registrationDetail.modifiedDate}</td>
                    </tr>
                    <tr>
                        <td>Modified By</td>
                        <td>${registrationDetail.modifiedBy}</td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Deregister" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/person/registrations' />">Cancel</a>
        </div>
    </div>
    </form:form>

    <div class="panel">
        <jsp:include page="footer.jsp"/>
    </div>

</div>
</body>
</html>