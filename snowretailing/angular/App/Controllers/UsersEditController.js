(function () {
    angular.module("Snowretailing").controller("UsersEditController", UsersEditController);

    function UsersEditController($scope,queryService,constantService) {
        queryService.asyncGet(constantService.USERS_URL).then(function (response) {
            $scope.users = response;
        });
    };
})();