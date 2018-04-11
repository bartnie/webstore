<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
    <title>
        <spring:message code="cart.title"/>
    </title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>
                <spring:message code="cart.header.header"/>
            </h1>
            <p>
                <spring:message code="cart.header.desc"/>
            </p>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" nginit="initCartId('${cartId}')">
        <div>
            <a class="btn btn-danger pull-left" ng-click="clearCart()">
                <span class="glyphicon glyphicon-remove-sign"></span>
                <spring:message code="cart.button.remove"/>
            </a>
            <a href="#" class="btn btn-success pull-right">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                <spring:message code="cart.button.buy"/>
            </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>
                    <spring:message code="cart.table.header.product"/>
                </th>
                <th>
                    <spring:message code="cart.table.header.price.unit"/>
                </th>
                <th>
                    <spring:message code="cart.table.header.units"/>
                </th>
                <th>
                    <spring:message code="cart.table.header.price.total"/>
                </th>
                <th>
                    <spring:message code="cart.table.header.action"/>
                </th>
            </tr>
            <tr ng-repeat="entry in cart.cartEntries">
                <td>{{entry.productid}}-{{entry.product.name}}</td>
                <td>{{entry.product.unitPrice}}</td>
                <td>{{entry.quantity}}</td>
                <td>{{entry.totalPrice}}</td>
                <td>
                    <a href="#" class="label label-danger" ng-click="removeFromCart(entry.product.id)">
                        <span class="glyphincon glyphicon-remove"></span>
                        <spring:message code="cart.button.delete"/>
                    </a>
                </td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>
                    <spring:message code="cart.table.footer.price.grandtotal"/>
                </th>
                <th>{{cart.grantTotal}}</th>
                <th></th>
            </tr>
        </table>
        <a href="<spring:url value="/products"/>" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span>
            <spring:message code="cart.button.back"/>
        </a>
    </div>
</section>
</body>
</html>