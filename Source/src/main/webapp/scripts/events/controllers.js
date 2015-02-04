/**
 * Created by Alex on 2/3/15.
 */

const SERVER_ADDRESS = "http://localhost:8080/Registration";
//const SERVER_ADDRESS = "http://javabootcamp01.sgt.com:8080/Registration";

var event = angular.module('Registration', ['ngRoute']);

event.config(['$routeProvider', function($routeProvider) {
    //Configuration

    $routeProvider
        .when("/myevents", {
            templateUrl : "views/events/listmyevents.html",
            controller : "MyEventsController"
        })
        .when("/event/:eventId", {
            templateUrl : "views/events/viewevent.html",
            controller : "EventViewController"
        });
}]);




    //Controllers

    // My Events Controller
event.controller('MyEventsController', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "My Events";

    }]);

    // Event View Controller
event.controller('EventViewController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = $scope.event.title;
        $scope.user = {};

        $scope.getEvent($routeParams.eventId);


        $scope.getEvent = function(eventId) {
            $http.get(SERVER_ADDRESS + '/resource/event/'+ eventId).
                success(function(data) {
                    $scope.event = data;
                }).
                error(function(data, status) {
                    console.log("Failed to get information" + status);
                });
        };

    }]);

    /*
    .controller('RegistrationController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
    }]);
    */

