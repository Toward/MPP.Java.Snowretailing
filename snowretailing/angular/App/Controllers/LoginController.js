(function () {
    angular.module("Snowretailing").controller("LoginController", LoginController);

    function LoginController($rootScope, $scope ,$location, queryService,constantService, userService) {
        $scope.login = function(user){
            queryService.asyncPost(constantService.LOGIN_URL, user).then(function (response) {
                userService.setUser(response);
                $rootScope.isAuthorized = true;
                $rootScope.userName = user.login;
                $location.path('/');
            });
        }
    };
})();