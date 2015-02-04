<<<<<<< HEAD

angular.module('app.user', [
    'ngRoute',
    '$scope',
    '$http',
    '$location',
    'ngSubmit',
    'ngRoute'
])

    //Configuration
    .config(function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "../views/login.html",
                controller : "UserLoginCntrl"
            })
            .when("/user/:userId", {
                templateUrl : "../views/profile.html",
                controller : "UpdateProfileController"
            })
            .when("/user/", {
                templateUrl : "../views/profile.html",
                controller : "Registration Controller"
            })
    })

    //Controllers

    //Login Controller
    .controller('UserLoginCntrl', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "Login";

    }])

    //Update Profile
    .controller('UpdateProfileController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Profile";
        $scope.user = {};

        $scope.getUser($routeParams.userId);


        $scope.getUser = function(userId) {
            $http.get('INSERT_GET_URL'+ userId).
                success(function(data) {
                    $scope.user = data;
                }).
                error(function(data, status) {
                    console.log("Failed to get information" + status);
                });
        };


        $scope.updateProfile = function() {

        };

    }])

    .controller('RegistrationController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
    }]);

=======

var profileApp = angular.module('app.user', ['ngRoute'])

    //Configuration
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "views/user/login.html",
                controller : "UserLoginCntrl"
            })
            .when("/user/:userId", {
                templateUrl : "views/user/profile.html",
                controller : "UpdateProfileController"
            })
            .when("/user/", {
                templateUrl : "../views/user/profile.html",
                controller : "Registration Controller"
            })
    }])

    //Controllers

    //Login Controller
    .controller('UserLoginCntrl', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "Login";

    }])

    //Update Profile
    .controller('UpdateProfileController', [ '$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Profile";
        $scope.user = {};

        $scope.getUser($routeParams.userId);


        $scope.getUser = function(userId) {
            $http.get('INSERT_GET_URL'+ userId).
                success(function(data) {
                    $scope.user = data;
                }).
                error(function(data, status) {
                    console.log("Failed to get information" + status);
                });
        };


        $scope.updateProfile = function() {

        };

    }])

    .controller('RegistrationController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
    }]);

>>>>>>> 77e6b94e6d679c8e3a576f6ef2958f20d5b7a82f
