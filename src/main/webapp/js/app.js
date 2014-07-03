var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/geek/showAllGeeks').success(function(geek) {
        $scope.geeks = geek;
    });
});