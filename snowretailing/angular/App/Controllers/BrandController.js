(function () {
   angular.module("Snowretailing").controller("BrandController", BrandController);

   function BrandController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.BRANDS_GET_URL).then(function (response) {
         $scope.brands = response;
       });
   };
})();