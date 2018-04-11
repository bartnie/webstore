/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

var cartApp = angular.module('cartApp', []);
cartApp.controller('cartCtrl', function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        $http.get('/cart/rest/' + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            });
    };
    $scope.clearCart = function () {
        $http.delete('/cart/rest/' + $scope.cartId)
            .success($scope.refreshCart($scope.cartId))
    };

    $scope.initCart = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function (productId) {
        $http.post('/cart/rest/add/' + productId)
            .success(function (data) {
                $scope.refreshCart($http.get('/cart/current/cartId'));
                alert("Product added to cart");
            });
    };

    $scope.removeFromCart = function (productId) {
        $http.post('/cart/rest/remove/' + productId)
            .success(function (data) {
                $scope.refreshCart($http.get('/cart/current/cartId'));
            });
    };

});