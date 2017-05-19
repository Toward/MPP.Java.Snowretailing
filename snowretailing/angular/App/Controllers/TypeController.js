(function () {
   angular.module("Snowretailing").controller("TypeController", TypeController);

   function TypeController($scope,queryService,constantService) {
       getTypes = function () {
           queryService.asyncGet(constantService.TYPES_URL).then(function (response) {
               $scope.types = response;
           },
                function (message){
                    toastr.info(message);
                });
       };

       $scope.showModal = function (modalMode, type) {
        $scope.modalMode = modalMode;
        if(type != null){
            $scope.type = type;
        }
            $('#modal').modal('toggle');
        }

        $scope.delete = function (id) {
            queryService.asyncDelete(constantService.TYPES_URL.concat("/").concat(id)).then(function () {
                getTypes();
            },
                function (message){
                    toastr.info(message);
                }

            );
        };

        $scope.create = function (type) {
            queryService.asyncPost(constantService.TYPES_URL, type).then(function () {
                                $scope.type = null;
                $('#modal').modal('toggle');
                getTypes();
            },
                function (message){
                    toastr.info(message);
                }
            );
        };

        $scope.update = function (type) {
            queryService.asyncPut(constantService.TYPES_URL, type).then(function () {
                                $scope.type = null;
                $('#modal').modal('toggle');
                getTypes();
            },
                function (message){
                    toastr.info(message);
                }
            );
        };

                $scope.hideModal = function () {
            $scope.type = null;
            getTypes();
        };
        getTypes();
   };
})();