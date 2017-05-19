(function () {
   angular.module("Snowretailing").controller("RentController", RentController);

   function RentController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.RENTS_GET_URL).then(function (response) {
         $scope.rents = response;
       });
   };
})();