<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Address Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/header.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/footer.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/autosuggest-main.css' />" rel="stylesheet"/>
    <link href="http://code.jquery.com/ui/1.9.0/themes/smoothness/jquery-ui.css" rel="stylesheet"/>


</head>

<body>

<div class="generic-container">

    <div class="panel">
        <jsp:include page="header.jsp"/>
    </div>

    <div class="well lead">Address Registration Form</div>
    <%--@elvariable id="addressRegistration" type="de.cosmicit.kvr.model.Registration"--%>
    <form:form method="POST" modelAttribute="addressRegistration" class="form-horizontal">
        <form:input type="hidden" path="person.id" id="personId"/>


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
                            <div class="div-td col-sm-6" id="find_keyword">
                                <spring:bind path="person.firstName">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <div class="ui-widget">
                                        <form:input type="text" id="firstName" path="person.firstName" class="form-control input-sm" placeholder="Enter first Name"
                                                    autofocus="true" onFocus="inputFocus(this)" onBlur="inputBlur(this)"></form:input>
                                        <form:errors path="person.firstName"></form:errors>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Last Name</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="person.lastName">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" id="lastName" path="person.lastName" class="form-control input-sm" placeholder="Enter Last Name"
                                                    autofocus="true"></form:input>
                                        <form:errors path="person.lastName"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Gender</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="person.gender">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:radiobutton path="person.gender" value="M" label="Male"/>
                                        <form:radiobutton path="person.gender" value="F" label="Female"/>
                                        <form:errors path="person.gender"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Date of Birth</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="person.birthDate">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" id="birthDate" path="person.birthDate" class="datepicker input-sm" placeholder="Birth Date(dd/MM/yy)"
                                                    autofocus="true"></form:input>
                                        <form:errors path="person.birthDate"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Contact</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="person.phoneNumber">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" id="phoneNumber" path="person.phoneNumber" class="form-control input-sm" placeholder="Enter Phone number"
                                                    autofocus="true"></form:input>
                                        <form:errors path="person.phoneNumber"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Email</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="person.email">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" id="email" path="person.email" class="form-control input-sm" placeholder="Enter Email"
                                                    autofocus="true"></form:input>
                                        <form:errors path="person.email"></form:errors>
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
        <div class="panel panel-primary">
            <div class="panel-body">
                <h6 class="text-on-pannel text-primary"><strong class="text-uppercase"> Current Address </strong></h6>
                <div class="div-table col-sm-12">
                    <div class="row">
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Street</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="currentAddress.street">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.street" class="form-control input-sm" placeholder="Enter Street"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.street"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">House #</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="currentAddress.houseNumber">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.houseNumber" class="form-control input-sm" placeholder="House Number"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.houseNumber"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">City</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="currentAddress.city">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.city" class="form-control input-sm" placeholder="Enter City"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.city"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Zip Code</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="currentAddress.zip">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.zip" class="form-control input-sm" placeholder="Zip Code"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.zip"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                        <div class="div-tr">
                            <div class="div-td col-sm-1">
                                <label class="control-lable">State</label>
                            </div>
                            <div class="div-td col-sm-6">
                                <spring:bind path="currentAddress.state">
                                    <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.state" class="form-control input-sm" placeholder="Enter State"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.state"></form:errors>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="div-td col-sm-1">
                                <label class="control-lable">Country</label>
                            </div>
                            <div class="div-td col-sm-4">
                                <spring:bind path="currentAddress.country">
                                    <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="currentAddress.country" class="form-control input-sm" placeholder="Country"
                                                    autofocus="true"></form:input>
                                        <form:errors path="currentAddress.country"></form:errors>
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

            <div class="panel panel-primary">
                <div class="panel-body">
                    <h6 class="text-on-pannel text-primary"><strong class="text-uppercase"> Previous Address </strong></h6>
                    <div class="div-table col-sm-12">
                        <div class="row">
                            <div class="div-tr">
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">Street</label>
                                </div>
                                <div class="div-td col-sm-6">
                                    <spring:bind path="previousAddress.street">
                                        <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.street" class="form-control input-sm" placeholder="Enter Street"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.street"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">House #</label>
                                </div>
                                <div class="div-td col-sm-4">
                                    <spring:bind path="previousAddress.houseNumber">
                                        <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.houseNumber" class="form-control input-sm" placeholder="House Number"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.houseNumber"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                            </div>
                            <div class="div-tr">
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">City</label>
                                </div>
                                <div class="div-td col-sm-6">
                                    <spring:bind path="previousAddress.city">
                                        <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.city" class="form-control input-sm" placeholder="Enter City"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.city"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">Zip Code</label>
                                </div>
                                <div class="div-td col-sm-4">
                                    <spring:bind path="previousAddress.zip">
                                        <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.zip" class="form-control input-sm" placeholder="Zip Code"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.zip"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                            </div>
                            <div class="div-tr">
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">State</label>
                                </div>
                                <div class="div-td col-sm-6">
                                    <spring:bind path="previousAddress.state">
                                        <div class="form-group  col-sm-8 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.state" class="form-control input-sm" placeholder="Enter State"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.state"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div class="div-td col-sm-1">
                                    <label class="control-lable">Country</label>
                                </div>
                                <div class="div-td col-sm-4">
                                    <spring:bind path="previousAddress.country">
                                        <div class="form-group  col-sm-6 ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="previousAddress.country" class="form-control input-sm" placeholder="Country"
                                                        autofocus="true"></form:input>
                                            <form:errors path="previousAddress.country"></form:errors>
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
            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
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
<script type="text/javascript" src='/static/js/autoCompleteAJAX.js' ></script>
<script type="text/javascript" src='/static/js/dateFormatUtil.js' ></script>
<!--
<script type="text/javascript" src='/static/js/jquery.autocomplete.min.js' ></script>
-->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
</body>
</html>