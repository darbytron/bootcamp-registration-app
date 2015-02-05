/* Server URLS */
//var URL = {
//    userById :  "http://10.224.87.131:8080/Registration/resource/user/",
//    userByEmail : "http://10.224.87.131:8080/Registration/resource/user/login",
//    editUser : "http://10.224.87.131:8080/Registration/resource/user"
//};

/* Localhost URLS */
var URL = {
    userById :  "http://localhost:8080/Registration/resource/user/",
    userByEmail : "http://localhost:8080/Registration/resource/user/login",
    editUser : "http://localhost:8080/Registration/resource/user"
};


angular.module('app.user', []);

angular.module('app.user').service('EmailService', function() {
    this.email = "";

    this.setEmail = function(e) {
        this.email = e;
    };

    this.getEmail = function(){
        return this.email;
    }

})

    //Login Controller
    .controller('UserLoginCntrl', ['$scope', '$location', '$http', 'EmailService', function($scope, $location, $http, EmailService){

        $scope.login = function() {

            var req = {
                method: 'POST',
                url: URL.userByEmail,
                headers: {
                    'Content-Type': "text/plain"
                },
                data: $scope.email
            };

            $http(req).success(function(data, status){
                if(data == ""){
                    //alert("New user!");
                    $location.path("/register");
                    EmailService.setEmail($scope.email);
                    console.log(status);
                } else {
                    $location.path("/user/view/" + data.id)
                    //alert ("Taking you to events...");

                }
            }).error(function(data, status){
                console.log(status);
                alert("Something went wrong :(");
            });

        }
    }])

    .controller('EditProfileController', [ '$scope', '$location', '$http', 'EmailService', '$routeParams', function($scope, $location, $http, EmailService, $routeParams) {

        $scope.pageConfig.emailReadOnly = "";
        if ($routeParams.userId != null)
        {
                $scope.pageConfig.emailReadOnly = "readonly";

                $http.get(URL.userById + $routeParams.userId).
                    success(function(data) {
                        $scope.user = data;
                    }).
                    error(function(data, status) {
                        console.log("Failed to get information" + status);
                        alert("Something went wrong :(");
                    });

        }
        else
        {
            $scope.user.email = EmailService.getEmail();
        }


        $scope.updateProfile = function () {
            console.log($scope.user.toJSON());
            if ($scope.user.id != null)
            {
                // User exists, just need to update
                $http.put(URL.editUser, $scope.user)
                    .success(function(data, status){
                        //alert("User successfully created!");
                        $location.path("/user/view/" + $data.id)
                    })
                    .error(function(data, status){
                        console.log( status );
                        alert("Something went wrong :(");
                    });
            }
            else
            {
                // Create a new user
                $http.put(URL.editUser, $scope.user)
                    .success(function(data, status){
                        //alert("User successfully created!");
                        $location.path("/user/view/" + $data.id)
                    })
                    .error(function(data, status){
                        console.log( status );
                        alert("Something went wrong :(");
                    });
            }

        }
    }])

    //.controller('UpdateProfileController', [ '$scope', '$location', '$http', 'EmailService', function($scope, $location, $http, EmailService) {
    //
    //    //$scope.user.email = EmailService.getEmail();
    //
    //    $scope.submitRegistration = function () {
    //        //console.log($scope.user.toJSON());
    //        $http.post(URL.editUser, $scope.user)
    //            .success(function(data, status){
    //                alert("User successfully created!");
    //                $location.path("/user/view/" + $data.id)
    //            })
    //            .error(function(data, status){
    //                alert("Something went wrong" + status);
    //
    //            });
    //    }
    //}])

.controller('ViewProfileController', [ '$scope', '$location', '$http', 'EmailService', function($scope, $location, $http, EmailService) {
    //$scope.pageTitle = "Registration";

    //$scope.user.email = EmailService.getEmail();


    $scope.user = {
        "firstName": "Alex",
        "lastName": "Krebiehl",
        "email" : "alex@krebiehl.com",
        "homeAddress": "50 Hidden Valley Dr #51",
        "city": "Highland Heights",
        "state": "KY",
        "zip": "41076",
        "country": "United States",
        "primaryPhone": "(513) 418-1163",
        "secondaryPhone": ""
    };
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