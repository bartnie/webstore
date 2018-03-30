<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Copyright (c) 2018.
  ~ Bartosz Niesobski - All rights reserved.
  --%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="/resources/style.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>
        <spring:message code="addProduct.title"/>
    </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <form action="<c:url value="/j_spring_security_logout"></c:url>" method="post" class="pull-right">
                <spring:message code="addProduct.header.greeting"/>
                <b><c:out value="${pageContext.request.remoteUser}"/></b>
                <fieldset>
                    <input class="btn btn-danger btn-mini" type="submit" value=
                    <spring:message code="addProduct.button.logout"/>
                    >
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </fieldset>
            </form>
            <div class="dropdown pull-right">
                <button class="dropbtn"><spring:message code="language.button.title"/></button>
                <div class="dropdown-content">

                    <a href="?lang=pl">
                        <spring:message code="language.pl"/>
                    </a>
                    <a href="?lang=en">
                        <spring:message code="language.en"/>
                    </a>
                </div>
            </div>
            <h1>
                <spring:message code="addProduct.header.header"/>
            </h1>
            <p>
                <spring:message code="addProduct.header.desc"/>
            </p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
            <legend>
                <spring:message code="addProduct.form.legend"/>
            </legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productId" path="id" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productName">
                    <spring:message code="addProduct.form.productName.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productName" path="name" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productPrice">
                    <spring:message code="addProduct.form.productPrice.label"/>
                </label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="productPrice" path="unitPrice" type="text" class="form:input-large"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productManufacturer">
                    <spring:message code="addProduct.form.productManufacturer.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productManufacturer" path="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productCategory">
                    <spring:message code="addProduct.form.productCategory.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productCategory" path="category" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productInStock">
                    <spring:message code="addProduct.form.productInStock.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productDesc">
                    <spring:message code="addProduct.form.productDesc.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productDesc" path="description" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productCondition">
                    <spring:message code="addProduct.form.productCondition.label"/>
                </label>
                <div class="col-lg-10">
                    <form:radiobutton id="productCondition" path="condition" value="NEW"/>
                    <spring:message code="addProduct.form.productCondition.condition.new"/>
                    <form:radiobutton id="productCondition" path="condition" value="USED"/>
                    <spring:message code="addProduct.form.productCondition.condition.used"/>
                    <form:radiobutton id="productCondition" path="condition" value="REFURBISHED"/>
                    <spring:message code="addProduct.form.productCondition.condition.refurbished"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value=
                        <spring:message code="addProduct.form.button.submit"/>
                    />
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>