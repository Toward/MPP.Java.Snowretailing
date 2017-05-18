(function () {
    angular.module("Snowretailing").controller("HeaderController", LoginController);

    function LoginController($rootScope, $scope, $location, userService) {
        $rootScope.isAuthorized = userService.isUserExist();
        $rootScope.currentUser = userService.getCurrentUser();
        $scope.logout = function(){
            userService.removeUser();
            $rootScope.isAuthorized = false;
            $rootScope.currentUser = null;
            $location.path('/');
        }
    };
})();