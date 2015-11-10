<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">

    <div class="starter-template">
        <h1>Cost1km</h1>

        <p class="lead">Стоимость километра пробега</p>
    </div>

    <form role="form" method="post">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="row">
                    <div class="radio">
                        <div class="col-md-6">
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios1"
                                       value="option1">
                                За весь период
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios2"
                                       value="option2">
                                По годам
                            </label>
                        </div>
                    </div>
                </div>
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">2015</a></li>
                    <li><a href="#">2014</a></li>
                    <li><a href="#">2013</a></li>
                    <li><a href="#">2012</a></li>
                    <li><a href="#">2011</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
                <div ng-app="myApp" ng-controller="personCtrl">

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" ng-click="toggle()"> машина в кредит?
                        </label>
                    </div>

                    <div ng-show="myVar">
                        <div class="form-group">
                            <label>Процентная ставка</label>

                            <div class="input-group">
                                <input type="text" class="form-control" name="cost">
                                <span class="input-group-addon">%</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Сумма кредита</label>

                            <div class="input-group">
                                <input type="text" class="form-control">
                                <span class="input-group-addon">руб.</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Срок</label>

                            <div class="input-group">
                                <input type="text" class="form-control">
                                <span class="input-group-addon">месяцев</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Переплата</label>

                            <div class="input-group">
                                <input type="text" class="form-control">
                                <span class="input-group-addon">руб.</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Цена авто</label>

                        <div class="input-group">
                            <input type="text" class="form-control" name="price" name="price" id="price" value=${price}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Пробег</label>

                        <div class="input-group">
                            <input type="text" class="form-control" name="milesOn" value=${milesOn}>
                            <span class="input-group-addon"> км</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Расходы на бензин</label>

                        <div class="input-group">
                            <input type="text" class="form-control" name="benzine" value=${benzine}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Прочее расходы</label>

                        <div class="input-group">
                            <input type="text" class="form-control" name="otherExpenses"
                                   value=${otherExpenses}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Цена продажи (рыночная)</label>

                        <div class="input-group">
                            <input type="text" class="form-control" name="sellingPrice"
                                   value=${sellingPrice}>
                            <span class="input-group-addon">руб.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>${cost1km}</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Отправить</button>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form>
</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('personCtrl', function ($scope) {
        $scope.person = {
            firstName: "John",
            lastName: "Doe"
        };
        $scope.myVar = false;
        $scope.toggle = function () {
            $scope.myVar = !$scope.myVar;
        };
    });
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
