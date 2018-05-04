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

    <div class="well lead">Search Registrations for a Person</div>
    <%--@elvariable id="personSearchRegistration" type="de.cosmicit.kvr.model.Person"--%>
    <form:form method="GET" modelAttribute="personSearchRegistration" class="form-horizontal" action="/person/findregistrations">
        <form:input type="hidden" path="id" id="id"/>

        <p>
            Please enter the criteria for searching registration details of the Person..
        </p>

    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <h6 class="text-on-pannel text-primary"><strong class="text-uppercase"> Personal Details </strong></h6>
                <div class="div-table col-sm-12">
                    <div class="row">
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">First Name</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="firstName">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="firstName" class="form-control input-sm" placeholder="Enter first Name"
                                                    autofocus="true"></form:input>
                                        <form:errors path="firstName"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Last Name</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="lastName">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="lastName" class="form-control input-sm" placeholder="Enter Last Name"
                                                    autofocus="true"></form:input>
                                        <form:errors path="lastName"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Search" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
        </div>
    </div>
    </form:form>

    <div class="panel">
        <jsp:include page="footer.jsp"/>
    </div>
</div>

<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src='/static/js/app.js' ></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
</body>
</html>