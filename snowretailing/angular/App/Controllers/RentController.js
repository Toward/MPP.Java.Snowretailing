(function () {
   angular.module("Snowretailing").controller("RentController", RentController);

   function RentController($scope,queryService,constantService) {
       getRents = function() {
           queryService.asyncGet(constantService.RENTS_URL).then(function (response) {
               $scope.rents = response;
           });
       };


        $scope.showModal = function (modalMode, rent) {
        $scope.modalMode = modalMode;
        if(rent != null){
            $scope.rent = rent;
        }
            $('#modal').modal('toggle');
        }

        $scope.delete = function (id) {
        queryService.asyncDelete(constantService.RENTS_URL.concat("/").concat(id)).then(function () {
            getRents();
        });
        };

        $scope.create = function (rent) {

            queryService.asyncPost(constantService.RENTS_URL, rent).then(function () {
                getRents();
            });
        };

        $scope.update = function (rent) {
            queryService.asyncPut(constantService.RENTS_URL, rent).then(function () {
                getRents();
            });
        };
        getRents();
   };
})();