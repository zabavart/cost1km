<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cost1km</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/starter-template.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Cost1km</a>
        </div>
        <div class="collapse navbar-collapse"></div>
    </div>
</div>

<div class="container">

    <div class="starter-template">
        <h1>Cost1km</h1>

        <p class="lead">Стоимость километра пробега</p>
    </div>

    <form role="form" method="post" id="mainForm">

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-6">
                <div class="row">
                    <div class="radio">
                        <div class="col-md-6">
                            <label><input type="radio" name="optionsRadios" id="allPeriod">За весь период</label>
                        </div>
                        <div class=col-md-6">
                            <label><input type="radio" name="optionsRadios" id="yearPeriod">По годам</label>
                        </div>
                    </div>
                </div>

                <ul class="pagination" id="years">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">2015</a></li>
                    <li><a href="#">2014</a></li>
                    <li><a href="#">2013</a></li>
                    <li><a href="#">2012</a></li>
                    <li><a href="#">2011</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="alert alert-warning alert-dismissible fade in text-center" id="carMiniInfo">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">

                <div id="carGroup">
                    <div class="form-group">
                        <label>Марка</label>
                        <select class="form-control" id="carMark">
                            <c:forEach items="${carMarkList}" var="entry">
                                <option value=${entry.key}>${entry.value}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Модель</label>
                        <select class="form-control" id="carModel">
                            <c:forEach items="${carModelList}" var="entry">
                                <option value=${entry.key}>${entry.value}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Серия</label>
                        <select class="form-control" id="carSerie"></select>
                    </div>

                    <div class="form-group">
                        <label>Модификация</label>
                        <select class="form-control" id="carModification"></select>
                    </div>
                </div>

                <%--<div class="checkbox" id="isCredit">--%>
                    <%--<label>--%>
                        <%--<input type="checkbox" id="isCreditCheckbox">машина в кредит?--%>
                    <%--</label>--%>
                <%--</div>--%>

                <%--<div id="creditGroup">--%>
                    <%--<div class="form-group">--%>
                        <%--<label>Процентная ставка</label>--%>

                        <%--<div class="input-group">--%>
                            <%--<input type="text" class="form-control" id="cost">--%>
                            <%--<span class="input-group-addon">%</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label>Сумма кредита</label>--%>

                        <%--<div class="input-group">--%>
                            <%--<input type="text" class="form-control">--%>
                            <%--<span class="input-group-addon">руб.</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label>Срок</label>--%>

                        <%--<div class="input-group">--%>
                            <%--<input type="text" class="form-control">--%>
                            <%--<span class="input-group-addon">месяцев</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label>Переплата</label>--%>

                        <%--<div class="input-group">--%>
                            <%--<input type="text" class="form-control">--%>
                            <%--<span class="input-group-addon">руб.</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div id="costGroup">
                    <div class="form-group">
                        <label>Цена авто</label>

                        <div class="input-group">
                            <input type="text" class="form-control" id="price" value=${price}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Пробег</label>

                        <div class="input-group">
                            <input type="text" class="form-control" id="milesOn" value=${milesOn}>
                            <span class="input-group-addon"> км</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Расходы на бензин</label>

                        <div class="input-group">
                            <input type="text" class="form-control" id="benzine" value=${benzine}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Прочее расходы</label>

                        <div class="input-group">
                            <input type="text" class="form-control" id="otherExpenses" value=${otherExpenses}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Цена продажи (рыночная)</label>

                        <div class="input-group">
                            <input type="text" class="form-control" id="sellingPrice" value=${sellingPrice}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label id="cost1km">${cost1km}</label>
                    </div>

                    <button type="button" class="btn btn-primary" id="save">Сохранить</button>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form>
</div>

<script src="js/controller.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
