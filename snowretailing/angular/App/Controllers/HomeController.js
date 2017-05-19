(function () {
   angular.module("Snowretailing").controller("HomeController", HomeController);
   
   function HomeController($scope,queryService,constantService) {
       getEquipments = function () {
           queryService.asyncGet(constantService.EQUIPMENTS_GET_URL).then(function (response) {
               $scope.equipments = response;
           });
       };

              getTypes = function () {
           queryService.asyncGet(constantService.TYPES_URL).then(function (response) {
               $scope.types = response;
           });
       };

                     getBrands = function () {
           queryService.asyncGet(constantService.BRANDS_URL).then(function (response) {
               $scope.brands = response;
           });
       };

       getReviews = function() {
           queryService.asyncGet(constantService.REVIEWS_GET_URL).then(function (response) {
               $scope.reviews = response;
           });
       };

       $scope.showModal = function (modalMode, equipment) {
            $scope.modalMode = modalMode;
            if(equipment != null){
                $scope.equipment = equipment;
            }
            $('#modal').modal('toggle');
        };

        $scope.delete = function (id) {
            queryService.asyncDelete(constantService.EQUIPMENTS_GET_URL.concat("/").concat(id)).then(function () {
                getEquipments();
            });
        };

        $scope.create = function (equipment) {
            queryService.asyncPost(constantService.EQUIPMENTS_GET_URL, equipment).then(function () {
                getEquipments();
            });
        };

        $scope.update = function (equipment) {
            queryService.asyncPut(constantService.EQUIPMENTS_GET_URL, equipment).then(function () {
                getEquipments();
            });
        };

        getEquipments();
        getReviews();
       getTypes();
       getBrands();

   };
})();