(function () {
    angular.module("Snowretailing").controller("UsersEditController", UsersEditController);

    function UsersEditController($scope,queryService,constantService) {
        getUsers = function () {
            queryService.asyncGet(constantService.USERS_URL).then(function (response) {
                $scope.users = response;
            },
                function (message){
                    toastr.info(message);
                });
        };

        $scope.showModal = function (modalMode, user) {
            $scope.modalMode = modalMode;
            if (user !== null) {
                $scope.user = user;
                $scope.user.roleId = user.role.id;
            }
            $('#modal').modal('toggle');
        };

        $scope.showDeleteModal = function (user) {
            $scope.user = user;
            $('#modal-delete').modal('toggle');

            $scope.delete = function () {
                queryService.asyncDelete(constantService.USERS_URL.concat("/").concat(user.id)).then(function () {
                    $scope.user = null;
                    $('#modal-delete').modal('toggle');
                    getUsers();
            });
        };
        };

        $scope.create = function (user) {
            queryService.asyncPost(constantService.USERS_URL, user).then(function () {
                $scope.user = null;
                $('#modal').modal('toggle');
                getUsers();
            },
                function (message){
                    toastr.info(message);
                });
        };

        $scope.update = function (user) {
            queryService.asyncPut(constantService.USERS_URL, user).then(function () {
                $scope.user = null;
                $('#modal').modal('toggle');
                getUsers();
            },
                function (message){
                    toastr.info(message);
                });
        };

        $scope.hideModal = function () {
            $scope.user = null;
            getUsers();
        };

        getUsers();
    }
})();