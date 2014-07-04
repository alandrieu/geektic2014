var app = angular.module('geektic', [ 'ngRoute' ]);

// Main
app.controller('MainCtrl', function($scope, $http) {
	$http.get('/geek/showAllGeeks').success(function(data) {
		$scope.geeks = data;
	});

	// Récuperation des interets
	$http.get('/interets/showAllinterets').success(function(data) {
		$scope.interets = data;
	});
});

// Show By Id profil
app.controller('ProfilCtrl', function($scope, $http, $location, $routeParams) {
	$http.get('/geek/trouver/' + $routeParams.id).success(function(data) {
		$scope.geek = data;
	});
});

// Show By Nom prenom
app.controller('GeekByCritere',
		function($scope, $http, $location, $routeParams) {
			$http.get(
					'/geek/find/' + $routeParams.interet + '/'
							+ $routeParams.sexe).success(function(data) {
				$scope.geeks = data;
			});
		});

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/main.html',
		controller : 'MainCtrl'
	}).when('/profil/:id', {
		templateUrl : 'views/profil.html',
		controller : 'ProfilCtrl'
	}).when('/profil/:interet/:sexe', {
		templateUrl : 'views/result.html',
		controller : 'GeekByCritere'
	}).otherwise('/');
});