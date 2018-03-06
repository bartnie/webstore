<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>
        <spring:message code="products.title"/>
    </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>
                <spring:message code="products.header.header"/>
            </h1>
            <p>
                <spring:message code="products.header.desc"/>
            </p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice}
                            <spring:message code="products.product.productPrice.currency"/>
                        </p>
                        <p>
                            <spring:message code="products.product.productInStock"/>
                                ${product.unitsInStock}
                        </p>
                        <p>
                            <a href="<c:url value="/products/${product.id}"/>" class="btn btn-primary">
                                <span class="glyphicon glyphicon-info-sign "></span>
                                <spring:message code="products.button.info"/>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>