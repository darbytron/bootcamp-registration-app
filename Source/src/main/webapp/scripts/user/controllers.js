/*URL KEYS
http://10.224.87.131:8080/Registration/resource/user/{userID}       Returns user information by user id.
*/

var user = angular.module('Registration', ['ngRoute'])

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
            .when("/user", {
                templateUrl : "views/user/profile.html",
                controller : "Registration Controller"
            });
    }])

    //Controllers

    //Login Controller
    .controller('UserLoginCntrl', ['$scope', '$location', '$http', function($scope, $location, EmailService){
        $scope.pageTitle = "Login";

        $scope.login = function(email) {


            $http.post('ENTER LOGIN URL' , email).
                success(function(data, status, headers, config) {

                    if(data == null){
                        console.log("New user, take to registration page");
                        $location.path("/user");
                        EmailService.setEmail(email);

                    }

                }).
                error(function(data, status, headers, config) {
                    console.log( status );
                });
        }

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

    .controller('RegistrationController', [ '$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http, EmailService) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
        $scope.user.email = EmailService.getEmail();

        $scope.submitRegistration = function () {
            
        }
    }]);


user.service('EmailService', function() {
    this.email = "";

    this.setEmail = function(e) {
        this.email = e;
    };

    this.getEmail = function(){
        return this.email;
    }

});
