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

    <div class="well lead">List of Registered Persons</div>

    <c:if test="${not empty errorMessage}">
        <div class="form-group has-error">
                ${errorMessage} <a href="/person/search"> Search Again</a>
        </div>
    </c:if>


        <%--@elvariable id="person" type="de.cosmicit.kvr.model.Person"--%>
            <table class="table table-fixed">
                <thead>
                <tr>
                    <th class="col-sm-2">Firstname</th>
                    <th class="col-sm-2">Lastname</th>
                    <th class="col-sm-1">Email</th>
                    <th class="col-sm-2">Phone</th>
                    <th class="col-sm-2">Birthdate</th>
                    <th class="col-sm-1">Gender</th>
                    <th class="col-sm-2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td class="col-sm-2">${person.firstName}</td>
                        <td class="col-sm-2">${person.lastName}</td>
                        <td class="col-sm-1">${person.email}</td>
                        <td class="col-sm-2">${person.phoneNumber}</td>
                        <td class="col-sm-2">${person.birthDate}</td>
                        <td class="col-sm-1">${person.gender}</td>
                        <td class="col-sm-2">
                            <a href="<c:url value='/person/edit/${person.id}' />"
                               class="btn btn-success custom-width">edit</a>
                            <a href="<c:url value='/person/delete/${person.id}' />"
                               class="btn btn-danger custom-width">delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


    <div class="panel">
        <jsp:include page="footer.jsp"/>
    </div>

</div>
</body>

</html>