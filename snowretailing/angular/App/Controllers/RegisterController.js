(function () {
    angular.module("Snowretailing").controller("RegisterController", RegisterController);

    function RegisterController($rootScope, $scope ,$location, queryService,constantService, userService) {
        $scope.register = function(user){
            queryService.asyncPost(constantService.REGISTER_URL, user).then(function (response) {
                userService.setUser(response);
                $rootScope.isAuthorized = true;
                $rootScope.currentUser = userService.getCurrentUser();
                $location.path('/');
            },
                function (message){
                    toastr.info(message);
                });
        }
    }
})();