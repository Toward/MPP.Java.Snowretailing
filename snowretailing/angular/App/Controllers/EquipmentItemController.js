(function () {
   angular.module("Snowretailing").controller("EquipmentItemController", EquipmentItemController);

   function EquipmentItemController($scope,queryService,constantService) {
       getEquipmentItems = function () {
           queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL).then(function (response) {
               $scope.items = response;
           },
                function (message){
                    toastr.info(message);
                });
       };

       $scope.showModal = function (modalMode, item) {
        $scope.modalMode = modalMode;
        if(item != null){
            $scope.item = item;
        }
            $('#modal').modal('toggle');
        };


                $scope.showDeleteModal = function (item) {
            $scope.item = item;
            $('#modal-delete').modal('toggle');

               $scope.delete = function () {
                   queryService.asyncDelete(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(item.id)).then(function () {
                       getEquipmentItems();
                   });
               };
        };


       $scope.create = function (item) {
           queryService.asyncPost(constantService.EQUIPMENT_ITEMS_URL, item).then(function () {
                               $scope.item = null;
                $('#modal').modal('toggle');
               getEquipmentItems();
           },
                function (message){
                    toastr.info(message);
                });
       };

       $scope.update = function (item) {
           queryService.asyncPut(constantService.EQUIPMENT_ITEMS_URL, item).then(function () {
                               $scope.item = null;
                $('#modal').modal('toggle');
               getEquipmentItems();
           },
                function (message){
                    toastr.info(message);
                });
       };

       $scope.hideModal = function () {
            $scope.item = null;
            getEquipmentItems();
        };

       getEquipmentItems();
   };
})();