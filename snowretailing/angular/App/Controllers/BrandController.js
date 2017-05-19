(function () {
   angular.module("Snowretailing").controller("BrandController", BrandController);

   function BrandController($scope,queryService,constantService) {
       getBrands = function () {
           queryService.asyncGet(constantService.BRANDS_URL).then(function (response) {
               $scope.brands = response;
           });
       };


       $scope.showModal = function (modalMode, brand) {
        $scope.modalMode = modalMode;
        if(brand != null){
            $scope.brand = brand;
        }
            $('#modal').modal('toggle');
        };

        $scope.showDeleteModal = function (brand) {
            $scope.brand = brand;
            $('#modal-delete').modal('toggle');

            $scope.delete = function () {
                queryService.asyncDelete(constantService.BRANDS_URL.concat("/").concat(brand.id)).then(function () {
                    $scope.brand = null;
                    $('#modal-delete').modal('toggle');
                    getBrands();
            });
        };
        };

       $scope.create = function (rent) {
           queryService.asyncPost(constantService.BRANDS_URL, rent).then(function () {
                $scope.brand = null;
                $('#modal').modal('toggle');
               getBrands();
           });
       };

       $scope.update = function (rent) {
           queryService.asyncPut(constantService.BRANDS_URL, rent).then(function () {
                $scope.brand = null;
                $('#modal').modal('toggle');
               getBrands();
           });
       };

       $scope.hideModal = function () {
            $scope.brand = null;
            getBrands();
        };

       getBrands();
   };
})();