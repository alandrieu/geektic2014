var app = angular.module("geektic", [ 'ngRoute' ]);

// Main
app.controller('MainCtrl', function($scope, $http) {
	$http.get('/geek/showAllGeeks').success(function(data) {
		$scope.users = data;
	});
});

// Ajout d'un incrément au compteur
app.controller('RegisterCtrl', function($scope, $location, $http)
            {
                //$scope.user = {};
                $scope.register = function()
                {
                    $http.post('/geek/toto', $scope.user)
                    .success(function(data){
						$location.path("/");
                    });
                }
            });

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/index.html',
		controller : 'MainCtrl'
	}).when('/register', {
		templateUrl : 'views/register.html',
		controller : 'RegisterView'
	}).otherwise('/');
});