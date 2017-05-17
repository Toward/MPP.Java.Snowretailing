(function () {
    angular.module("Snowretailing").controller("HeaderController", LoginController);

    function LoginController($rootScope, $scope, $location, userService) {
        $rootScope.isAuthorized = userService.isUserExist();
        $rootScope.userName = userService.getLogin();
        $scope.logout = function(){
            userService.removeUser();
            $rootScope.isAuthorized = false;
            $rootScope.userName = null;
            $location.path('/');
        }
    };
})();