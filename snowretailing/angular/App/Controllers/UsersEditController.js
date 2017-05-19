(function () {
    angular.module("Snowretailing").controller("UsersEditController", UsersEditController);

    function UsersEditController($scope,queryService,constantService) {
        getUsers = function () {
            queryService.asyncGet(constantService.USERS_URL).then(function (response) {
                $scope.users = response;
            });
        };

        $scope.showModal = function (modalMode, user) {
            $scope.modalMode = modalMode;
            if(user != null){
                $scope.user = user;
                $scope.user.roleId = user.role.id;
            }
            $('#modal').modal('toggle');
        }

        $scope.delete = function (id) {
            queryService.asyncDelete(constantService.USERS_URL.concat("/").concat(id)).then(function () {
                getUsers();
            });
        };

        $scope.create = function (user) {
            queryService.asyncPost(constantService.USERS_URL, user).then(function () {
                getUsers();
            });
        };

        $scope.update = function (user) {
            queryService.asyncPut(constantService.USERS_URL, user).then(function () {
                getUsers();
            });
        };

        getUsers();
    };
})();