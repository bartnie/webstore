<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Copyright (c) 2018.
  ~ Bartosz Niesobski - All rights reserved.
  --%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkty</h1>
            <p>Dodaj produkty</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="product" class="form-horizontal">
        <fieldset>
            <legend>Dodaj nowy produkt</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productId">Id produktu</label>
                <div class="col-lg-10">
                    <form:input id="productId" path="id" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productName">Nazwa</label>
                <div class="col-lg-10">
                    <form:input id="productName" path="name" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productPrice">Cena</label>
                <div class="col-lg-10">
                    <div class="form:input-prepend">
                        <form:input id="productPrice" path="unitPrice" type="text" class="form:input-large"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productManufacturer">Producent</label>
                <div class="col-lg-10">
                    <form:input id="productManufacturer" path="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productCategory">Kategoria</label>
                <div class="col-lg-10">
                    <form:input id="productCategory" path="category" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productInStock">Dostepne sztuki</label>
                <div class="col-lg-10">
                    <form:input id="productInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productDesc">Opis</label>
                <div class="col-lg-10">
                    <form:input id="productDesc" path="description" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productCondition">Stan</label>
                <div class="col-lg-10">
                    <form:radiobutton id="productCondition" path="condition" value="NEW"/> Nowy
                    <form:radiobutton id="productCondition" path="condition" value="USED"/> Uzywany
                    <form:radiobutton id="productCondition" path="condition" value="REFURBISHED"/> Odnowiony
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>