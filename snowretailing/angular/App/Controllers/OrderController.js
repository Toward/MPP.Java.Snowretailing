(function () {
   angular.module("Snowretailing").controller("OrderController", OrderController);

   function OrderController($scope,queryService,constantService, userService) {
       $scope.isAuthorized = userService.isUserExist();
       queryService.asyncGet(constantService.ORDERS_GET_URL).then(function (response) {
         $scope.orders = response;
       });
   };
})();