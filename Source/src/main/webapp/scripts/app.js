
angular.module('app', ['ngRoute', 'app.user', 'app.event'])

    .config(function($routeProvider)
    {
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
            })
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
            })
            .otherwise({redirectTo: '/'});
	
    });


