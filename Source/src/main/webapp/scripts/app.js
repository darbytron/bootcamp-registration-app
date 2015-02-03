var registrationApp = angular.module('app', ['ngRoute']);

registrationApp.config(function($routeProvider)
{
	$routeProvider.when("/",
	{
		templateUrl: "../views/users.html",
		controller: "usersController"
	});

	$routeProvider.when("/lists/:userid",
	{
		templateUrl: "../views/listview.html",
		controller: "listsController"
	});

	$routeProvider.when("/listdetail/:listid",
	{
		templateUrl: "../views/listdetail.html",
		controller: "listDetailController"
	});
	
});

registrationApp.controller('usersController', ['$scope', '$http', '$location', function($scope, $http, $location){
	$scope.pageTitle = "Users";

    $http.get('resource/user').
        success(function(data, status, headers, config) {
            $scope.users = data;
        }).
        error(function(data, status, headers, config) {

        });

    $scope.displayListsForUser = function(userid) {
        /*resource/todolist/1*/

        $location.path('/lists/' + userid);
    };

    $scope.addNewUser = function() {

        var newUserData = { "firstName": $scope.firstName, "lastName": $scope.lastName, "username": "n/a" };
        $http.post('resource/user/', newUserData).
            success(function(data, status, headers, config) {
                $scope.users.push( newUserData );
                $scope.firstName = $scope.lastName = '';
            }).
            error(function(data, status, headers, config) {
                console.log( data );
            });

    };
}]);

registrationApp.controller('listsController', ['$scope', '$http', '$location', '$routeParams', function($scope, $http, $location, $routeParams){
	$scope.pageTitle = "Lists";

	$http.get('resource/todolist/user/' + $routeParams.userid).
	success(function(data, status, headers, config) {
		$scope.lists = data;
	}).
	error(function(data, status, headers, config) {

	});

	$scope.displayList = function(listid) {
		/*resource/todolist/1*/

		$location.path('/listdetail/' + listid);
	};

        $scope.createNewList = function() {

            var newListData = $scope.listName;
        $http.post('resource/todolist/' + $routeParams.userid, newListData).
            success(function(data, status, headers, config) {
                $scope.lists.push( data );
                $scope.listName = '';
            }).
            error(function(data, status, headers, config) {
                console.log( data );
            });

    };
}]);

registrationApp.controller('listDetailController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){

	$scope.pageTitle = "Loading list...";

	$http.get('resource/todolist/' + $routeParams.listid).
	success(function(data, status, headers, config) {
		$scope.pageTitle = data.name;
		$scope.data = data;
	}).
	error(function(data, status, headers, config) {

	});

	$scope.addNewTask = function() {

		var newTaskData = { "description": $scope.newTask, "active": "true" };
		$http.post('resource/todoitem/' + $routeParams.listid, newTaskData).
		success(function(data, status, headers, config) {
			$scope.data.todoItems.push( newTaskData );
			$scope.newTask = '';
		}).
		error(function(data, status, headers, config) {
			console.log( data );
		});

	};


}]);


