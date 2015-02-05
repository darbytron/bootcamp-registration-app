//URL KEYS
var URL = {
    userById :  "http://10.224.87.131:8080/Registration/resource/user/{userID}",
    userByEmail : "http://10.224.87.131:8080/Registration/resource/user/login",
    createUser : "http://10.224.87.131:8080/Registration/resource/user"
};
var URL_LOCAL = {
    userById :  "http://localhost:8080/Registration/resource/user/{userID}",
    userByEmail : "http://localhost:8080/Registration/resource/user/login",
    createUser : "http://localhost:8080/Registration/resource/user"
};
var user = angular.module('Registration', ['ngRoute']);



user.config(function($routeProvider) {

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
                controller : "RegistrationController"
            });

    });


user.service('EmailService', function() {
    this.email = "";

    this.setEmail = function(e) {
        this.email = e;
    };

    this.getEmail = function(){
        return this.email;
    }

});

    //Controllers

    //Login Controller
user.controller('UserLoginCntrl', ['$scope', '$location', '$http', 'EmailService', function($scope, $location, $http, EmailService){


        $scope.pageTitle = "Login";

        $scope.login = function() {

            var req = {
                method: 'POST',
                url: URL_LOCAL.userByEmail,
                headers: {
                    'Content-Type': "text/plain"
                },
                data: $scope.email
            };

            $http(req).success(function(data, status){
                if(data == ""){
                    //alert("New user!");
                    $location.path("/user");
                    EmailService.setEmail($scope.email);
                    console.log(status);
                } else {
                    alert ("Taking you to events...");

                }
            }).error(function(data, status){
                console.log(status);
            });

        }
    }]);

    //Update Profile
//user.controller('UpdateProfileController', [ '$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http) {
//        $scope.pageTitle = "Profile";
//        $scope.user = {};
//
//        $scope.getUser($routeParams.userId);
//
//
//        $scope.getUser = function(userId) {
//            $http.get('INSERT_GET_URL'+ userId).
//                success(function(data) {
//                    $scope.user = data;
//                }).
//                error(function(data, status) {
//                    console.log("Failed to get information" + status);
//                });
//        };
//
//
//        $scope.updateProfile = function() {
//
//        };
//
//    }]);
//
user.controller('RegistrationController', [ '$scope', '$location', '$routeParams', '$http', 'EmailService', function($scope, $location, $routeParams, $http, EmailService) {
        $scope.pageTitle = "Registration";

        $scope.user.email = EmailService.getEmail();

        $scope.submitRegistration = function () {
            console.log($scope.user.toJSON());
            $http.post(URL_LOCAL.createUser, $scope.user)
                .success(function(data, status){
                    alert("User successfully created!");
                })
                .error(function(data, status){
                    alert("Something went wrong" + status);

                });
        }
    }]);


//USER MODEL
//{
//    "firstName": "Tim",
//    "lastName": "Kelley",
//    "email": "tkelley@email.com",
//    "password" : "password",
//    "address1" : "address1",
//    "address2" : "address2",
//    "city" : "city",
//    "state" : "state",
//    "companyName" : "companyName",
//    "branchLocation" : "branchLocation",
//    "additionalInfo" : "addtionalInfo",
//    "zip" : "12345",
//    "phoneHome" : "134235",
//    "phoneOffice" : "134235",
//    "phoneCell" : "134235"
//}