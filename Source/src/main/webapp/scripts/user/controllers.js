
angular.module('app.user',
    [   'ngRoute',
        '$scope',
        '$http',
        '$location'
    ])

    //Configuration
    .config(function($routeProvider) {
        $routeProvider.when("/", {
            templateUrl : "../views/login.html",
            controller : "UserLoginCntrl"
        });
    })

    //Controllers
    .controller('UserLoginCntrl', function($scope){
        $scope.pageTitle = "Login";
    });