(function () {
   angular.module("Snowretailing").controller("OrderController", OrderController);

   function OrderController($rootScope, $scope,queryService,constantService, userService) {
       getOrders = function() {
           $scope.isAuthorized = userService.isUserExist();
           queryService.asyncGet(constantService.ORDERS_URL).then(function (response) {
               $scope.orders = response;
           });
       };
     $scope.showModal = function (modalMode, order) {
        $scope.modalMode = modalMode;
        if(order != null){
            $scope.order = order;
        }
            $('#modal').modal('toggle');
        }

       $scope.delete = function (id) {
           queryService.asyncDelete(constantService.ORDERS_URL.concat("/").concat(id)).then(function () {
               getOrders();
           });
       };

       $scope.create = function (order) {
           order.user = $rootScope.currentUser.login;
           order.state = 1;
          queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(order.equipmentItem.id)).then(function (response) {
               $scope.equipmentItem = response;
           });
           queryService.asyncPost(constantService.ORDERS_URL, order).then(function () {
               getOrders();
           });
       };

       $scope.update = function (order) {
                     queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(order.equipmentItem.id)).then(function (response) {
               $scope.equipmentItem = response;
           });
           queryService.asyncPut(constantService.ORDERS_URL, order).then(function () {
               getOrders();
           });
       };
       getOrders();

   };
})();