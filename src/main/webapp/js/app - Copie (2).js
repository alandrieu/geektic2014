var app = angular.module("geektic", [ 'ngRoute' ]);

// Main
app.controller('MainCtrl', function($scope, $http) {
	$http.get('/geek/showAllGeeks').success(function(data) {
		$scope.users = data;
	});
});

// Show Id profil
app.controller('GeekCtrl', function($scope, $http, $location, $routeParams)
{
	$http.get('/geek/find/' + $routeParams.id).success(function(data) {
		$scope.geek = data;
    });
});

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'views/main.html',
		controller : 'MainCtrl'
	}).when('/profil/:id', {
		templateUrl : 'views/profil.html',
		controller : 'ProfilCtrl'
	}).otherwise('/');
});