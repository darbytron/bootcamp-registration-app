/**
 * Created by Alex on 2/3/15.
 */
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

        //});

}]);




    //Controllers

    // My Events Controller
event.controller('MyEventsController', ['$scope', '$location', function($scope, $location){
        $scope.pageTitle = "My Events";

<<<<<<< HEAD
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

=======
>>>>>>> 77a695a5ded233957ad56158ea1e019afd8d1c1d
    }]);

    // Event View Controller
event.controller('EventViewController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
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

    }]);

    /*
    .controller('RegistrationController', [ '$scope', '$location', 'ngRoute', '$http', function($scope, $location, $routeParams, $http) {
        $scope.pageTitle = "Registration";
        $scope.user = {};
    }]);
    */

