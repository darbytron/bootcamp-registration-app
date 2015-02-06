/**
 * Created by Alex on 2/3/15.
 */
angular.module('app.event', ['ngRoute']);




//Controllers

// My Events Controller
angular.module('app.event').controller('MyEventsController', ['$scope', '$location', function($scope, $location){
    $scope.pageTitle = "My Events";


    var setUpTestInformation = function() {
        $scope.events = [];


        for(var i = 1; i < 11; i++){
            var testEvent = {
                "id" : i,
                "title" : "Test Event "+ i,
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

            $scope.events.push(testEvent);
        }

    };
    setUpTestInformation();



    $scope.displayEvent = function(eventId) {
        $location.path('/event/view/' + eventId);
    };

}])

// Event View Controller
.controller('EventViewController', [ '$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http) {


        $scope.event =
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

    //$scope.getEvent($routeParams.eventId);


    $scope.getEvent = function(eventId) {
        $http.get('/resource/event/'+ eventId).
            success(function(data) {
                $scope.event = data;
            }).
            error(function(data, status) {
                console.log("Failed to get information" + status);
            });
    };

}])

.controller('EditEventController', ['$scope', '$location', '$routeParams', '$http', function($scope, $location, $routeParams, $http){



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

