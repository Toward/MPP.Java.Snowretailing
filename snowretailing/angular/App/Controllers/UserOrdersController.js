(function () {
   angular.module("Snowretailing").controller("UserOrdersController", UserOrdersController);

   function UserOrdersController($rootScope, $scope, queryService, constantService, userService) {
       getOrders = function() {
           $scope.isAuthorized = userService.isUserExist();
           queryService.asyncGet(constantService.ORDERS_URL).then(function (response) {
               $scope.orders = response;
           });
       };

       getOrders();

   }
})();