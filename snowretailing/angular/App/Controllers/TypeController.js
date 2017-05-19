(function () {
   angular.module("Snowretailing").controller("TypeController", TypeController);

   function TypeController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.TYPES_GET_URL).then(function (response) {
         $scope.types = response;
       });
   };
})();