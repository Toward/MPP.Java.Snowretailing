(function () {
   angular.module("Snowretailing").controller("HomeController", HomeController);
   
   function HomeController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.EQUIPMENTS_GET_URL).then(function (response) {
         $scope.equipments = response;
       });

       queryService.asyncGet(constantService.REVIEWS_GET_URL).then(function (response) {
           $scope.reviews = response;
       });
   };
})();