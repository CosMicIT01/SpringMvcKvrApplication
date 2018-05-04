<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/header.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/footer.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">

    <div class="panel">
        <jsp:include page="header.jsp"/>
    </div>


    <div class="alert alert-danger lead">
        ${failureMessage}
    </div>

    <div class="panel">
        <jsp:include page="footer.jsp"/>
    </div>

</div>
</body>

</html>