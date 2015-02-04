/**
 * Created by Alex on 2/3/15.
 */

angular.module('app.events', [
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
            .when("/myevents", {
                templateUrl : "views/events/listmyevents.html",
                controller : "MyEventsController"
            })
            .when("/event/:eventId", {
                templateUrl : "views/events/viewevent.html",
                controller : "EventViewController"
            })
            /*
            .when("/user/", {
                templateUrl : "../views/profile.html",
                controller : "Registration Controller"
            })
            */
    })

    //Controllers

    // My Events Controller
    .controller('MyEventsController', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "My Events";

    }])

    // Event View Controller
    .controller('EventViewController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = $scope.event.title;
        $scope.user = {};

        $scope.getEvent($routeParams.eventId);


        $scope.getEvent = function(eventId) {
            $http.get('/resource/event/'+ eventId).
                success(function(data) {
                    $scope.event = data;
                }).
                error(function(data, status) {
                    console.log("Failed to get information" + status);
                });
        };

d
    }])

    /*
    .controller('RegistrationController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
    }]);
    */

