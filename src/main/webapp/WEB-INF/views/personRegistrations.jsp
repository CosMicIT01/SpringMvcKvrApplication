<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Person Registrations</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/table.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/header.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/footer.css' />" rel="stylesheet"/>


</head>
<body>
<div class="generic-container">
    <div class="panel">
        <jsp:include page="header.jsp"/>
    </div>

    <div class="well lead">Registrations for a ${personFullName}</div>

    <c:if test="${not empty errorMessage}">
        <div class="form-group has-error">
                ${errorMessage} <a href="/registration/search/person"> Search Again</a>
        </div>
    </c:if>

    <div class="row">
        <div class="panel panel-default">
            <table class="table table-fixed">
                <thead>
                <tr>
                    <th class="col-xs-1">Reg No.</th>
                    <th class="col-xs-3">Current Address</th>
                    <th class="col-xs-3">Previous Address</th>
                    <th class="col-xs-3">Registration Date</th>
                    <th class="col-xs-2">Created By</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="registration" items="${personRegistrations}">
                    <tr>
                        <td class="col-xs-1"><a href="/registration/${registration.id}">${registration.id}</a></td>
                        <td class="col-xs-3">
                                ${registration.currentAddress.street}&nbsp;
                                ${registration.currentAddress.houseNumber},&nbsp;
                                ${registration.currentAddress.zip},&nbsp;
                                ${registration.currentAddress.city}
                        </td>
                        <td class="col-xs-3">
                                ${registration.previousAddress.street}&nbsp;
                                ${registration.previousAddress.houseNumber},&nbsp;
                                ${registration.previousAddress.zip},&nbsp;
                                ${registration.previousAddress.city}
                        </td>
                        <td class="col-xs-3">${registration.registrationDate}</td>
                        <td class="col-xs-2">${registration.createdBy}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="panel">
        <jsp:include page="footer.jsp"/>
    </div>

</div>
</body>

</html>