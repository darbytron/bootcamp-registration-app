/**
 * Created by Alex on 2/3/15.
 */

const SERVER_ADDRESS = "http://localhost:8080/Registration/";
//const SERVER_ADDRESS = "http://javabootcamp01.sgt.com:8080/Registration";

var event = angular.module('Registration', ['ngRoute']);

event.config(['$routeProvider', function($routeProvider) {
    //Configuration

    $routeProvider
        .when("/myevents", {
            templateUrl : "views/events/listmyevents.html",
            controller : "MyEventsController"
        })
        .when("/event/view/:eventId", {
            templateUrl : "views/events/viewevent.html",
            controller : "EventViewController"
        })
        .when("/event/edit/:eventId", {
            templateUrl : "views/events/editevent.html",
            controller : "EventEditController"
        })
        .when("/event/new", {
            templateUrl : "views/events/editevent.html",
            controller : "EventEditController"
        })
        // The same controller will be used for editing and creating

        /*
        .when("/event/new", {
            templateURL : "views/events/editevent.html",
            controller : "EditEventController"
        })
         */
        .otherwise({redirectTo: '/'});
}]);







    //Controllers

    // My Events Controller
event.controller('MyEventsController', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "My Events";


    }]);

    // Event View Controller
event.controller('EventViewController', [ '$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http) {

        $scope.event = {
            "id" : 1,
            "title" : "test event",
            "startDate" : "10-24",
            "endDate" : "12-5",
            "category" : "some category",
            "type" : "some type",
            "description" : "blah blah blah",
            "owner" : "Krebiehl, Alex",
            "location" : "Dayton, OH",
            "status" : "Active",
            "registrations" : [
                { "firstName": "Tyler", "lastname": "Darby", "id": 7},
                { "firstName": "Jordan", "lastname": "Bossman", "id": 8},
                { "firstName": "Tyler", "lastname": "Robertson", "id": 9}
            ],
            "food" : [
                "Carrots",
                "Peas"
            ]
        };

       // $scope.getEvent($routeParams.eventId);
    $scope.pageTitle = $scope.event.title;

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

event.controller('EditEventController', ['$scope', '$location', '$routeParams', function($scope, $location, $routeParams){

    /*
    $scope.event = {
        "id" : 1,
        "title" : "test event",
        "startDate" : "10-24",
        "endDate" : "12-5",
        "category" : "some category",
        "type" : "some type",
        "description" : "blah blah blah",
        "owner" : "Krebiehl, Alex",
        "location" : "Dayton, OH",
        "status" : "Active",
        "registrations" : [
            { "firstName": "Tyler", "lastname": "Darby", "id": 7},
            { "firstName": "Jordan", "lastname": "Bossman", "id": 8},
            { "firstName": "Tyler", "lastname": "Robertson", "id": 9}
        ],
        "food" : [
            "Carrots",
            "Peas"
        ]
    };



    // $scope.getEvent($routeParams.eventId);
    $scope.pageTitle = $scope.event.title;

    // If eventId is set, we are editing, otherwise it is a new event
    if ($routeParams.eventId)
    {
        // Retrieve event details to edit
        $scope.getEvent = function(eventId) {
            $http.get(SERVER_ADDRESS + '/resource/event/'+ eventId).
                success(function(data) {
                    $scope.event = data;
                }).
                error(function(data, status) {
                    console.log("Failed to get information" + status);
                });
        };
    }

*/

}]);
