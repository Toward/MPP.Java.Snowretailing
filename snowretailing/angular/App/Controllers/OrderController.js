(function () {
   angular.module("Snowretailing").controller("OrderController", OrderController);

   function OrderController($rootScope, $scope,queryService,constantService, userService) {
       getOrders = function() {
           $scope.isAuthorized = userService.isUserExist();
           queryService.asyncGet(constantService.ORDERS_URL).then(function (response) {
               $scope.orders = response;
           },
                function (message){
                    toastr.info(message);
                });
       };
     $scope.showModal = function (modalMode, order) {
        $scope.modalMode = modalMode;
        if(order != null){
            $scope.order = order;
        }
            $('#modal').modal('toggle');
        };



       $scope.showDeleteModal = function (order) {
            $scope.order = order;
            $('#modal-delete').modal('toggle');

            $scope.delete = function () {
            queryService.asyncDelete(constantService.ORDERS_URL.concat("/").concat(order.id)).then(function () {
               $scope.order = null;
                $('#modal-delete').modal('toggle');
               getOrders();
           });
       };
        };

       $scope.create = function (order) {
           order.user = $rootScope.currentUser.login;
           order.state = 1;
          queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(order.equipmentItem.id)).then(function (response) {
               $scope.equipmentItem = response;
           },
                function (message){
                    toastr.info(message);
                });
                $scope.order = null;
                $('#modal').modal('toggle');
           queryService.asyncPost(constantService.ORDERS_URL, order).then(function () {
               getOrders();
           },
                function (message){
                    toastr.info(message);
                });
       };

       $scope.update = function (order) {
                     queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(order.equipmentItem.id)).then(function (response) {
               $scope.equipmentItem = response;
           });
                 $scope.order = null;
                $('#modal').modal('toggle');
           queryService.asyncPut(constantService.ORDERS_URL, order).then(function () {
               getOrders();
           },
                function (message){
                    toastr.info(message);
                });
       };

               $scope.hideModal = function () {
            $scope.order = null;
            getOrders();
        };

       getOrders();

   }
})();