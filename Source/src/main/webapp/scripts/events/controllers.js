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
        .when("/event/view/:eventId", {
            templateUrl : "views/events/viewevent.html",
            controller : "EventViewController"
        })
        .when("/event/edit/:eventId", {
            templateUrl : "views/events/editevent.html",
            controller : "EditEventController"
        })
        .when("/event/new", {
            templateUrl : "views/events/editevent.html",
            controller : "EditEventController"
        });
        // The same controller will be used for editing and creating

        /*
        .when("/event/new", {
            templateURL : "views/events/editevent.html",
            controller : "EditEventController"
        })
         */
        //.otherwise({redirectTo: '/'});
}]);







    //Controllers

    // My Events Controller
event.controller('MyEventsController', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "My Events";

    $scope.events = [
        {
        "id" : 1,
        "title" : "test event1",
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
    },
        {
            "id" : 2,
            "title" : "test event2",
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
        },
        {
            "id" : 3,
            "title" : "test event3",
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
        }];

    $scope.displayEvent = function(eventId) {
        $location.path('/event/view/' + eventId);
    };

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

event.controller('EditEventController', ['$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http){



    // If eventId is set, we are editing, otherwise it is a new event
    if ($routeParams.eventId != null)
    {


        /* test data */
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





        $scope.mainPanelTitle = "Edit Event";
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
    else
    {
        $scope.mainPanelTitle = "Create Event";
    }


    $scope.updateEvent = function() {

        if ($scope.event.id)
        {
            // We have an eventId, so we are editing an event
            $http.put(SERVER_ADDRESS + 'resource/event/' + $scope.event.id, $scope.event).
                success(function(data, status, headers, config) {

                    // navigate to event view page
                    $location.path('/event/' + $scope.event.id);
                }).
                error(function(data, status, headers, config) {
                    console.log( data );
                });
        }
        else
        {
            // no event id, so we are creating
            $http.post(SERVER_ADDRESS + 'resource/event/', $scope.event).
                success(function(data, status, headers, config) {

                    // navigate to event view page
                    $location.path('/event/' + $scope.event.id);
                }).
                error(function(data, status, headers, config) {
                    console.log( data );
                });
        }
    };
}]);
