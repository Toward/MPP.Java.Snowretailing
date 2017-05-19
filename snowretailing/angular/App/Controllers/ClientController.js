(function () {
   angular.module("Snowretailing").controller("ClientController", ClientController);

   function ClientController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.CLIENTS_GET_URL).then(function (response) {
         $scope.clients = response;
       });
   };
})();
