(function () {
    angular.module("Snowretailing").controller("EditPasswordController", EditPasswordController);

    function EditPasswordController($rootScope, $scope ,$location, queryService,constantService, userService) {
        $scope.change = function(user){
            user.login = userService.getLogin();
            queryService.asyncPost(constantService.CHANGE_PASSWORD_URL, user).then(function (response) {
                userService.setUser(response);
                $rootScope.isAuthorized = true;
                $rootScope.currentUser = userService.getCurrentUser();
                $location.path('/');
            });
        }
    }
})();