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
        }

       $scope.delete = function (id) {
           queryService.asyncDelete(constantService.BRANDS_URL.concat("/").concat(id)).then(function () {
               getBrands();
           });
       };

       $scope.create = function (rent) {
           queryService.asyncPost(constantService.BRANDS_URL, rent).then(function () {
               getBrands();
           });
       };

       $scope.update = function (rent) {
           queryService.asyncPut(constantService.BRANDS_URL, rent).then(function () {
               getBrands();
           });
       };
       getBrands();
   };
})();