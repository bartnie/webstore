<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>
        <spring:message code="product.title"/>
    </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>
                <spring:message code="product.header.header"/>
            </h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>
                    <spring:message code="product.product.productId"/>
                </strong>
                <span class="label label-warning">${productId}</span>
            </p>
            <p>
                <strong>
                    <spring:message code="product.product.productManufacturer"/>
                </strong>
                : ${product.manufacturer}
            </p>
            <p>
                <strong>
                    <spring:message code="product.product.productCategory"/>
                </strong>
                : ${product.category}
            </p>
            <p>
                <strong>
                    <spring:message code="product.product.productInStock"/>
                </strong>
                : ${product.unitsInStock}
            </p>
            <h4>
                ${product.unitPrice}
                <spring:message code="product.product.productPrice.currency"/>
            </h4>
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    <spring:message code="product.button.placeOrder"/>
                </a>
                <a href="<c:url value="/products"/>" class="btn btn-primary">
                    <span class="glyphicon-hand-left glyphicon"></span>
                    <spring:message code="product.button.back"/>
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>