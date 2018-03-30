<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Copyright (c) 2018.
  ~ Bartosz Niesobski - All rights reserved.
  --%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>
        <spring:message code="invalidPromoCode.title"/>
    </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">
                <spring:message code="invalidPromoCode.header.header"/> ${productId}
            </h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/products"/>" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span> <spring:message code="invalidPromoCode.button.back"/>
            </a>
        </p>
    </div>
</section>
</body>
</html>