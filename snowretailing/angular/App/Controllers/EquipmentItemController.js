(function () {
   angular.module("Snowretailing").controller("EquipmentItemController", EquipmentItemController);

   function EquipmentItemController($scope,queryService,constantService) {
       getEquipmentItems = function () {
           queryService.asyncGet(constantService.EQUIPMENT_ITEMS_URL).then(function (response) {
               $scope.items = response;
           });
       };

       $scope.showModal = function (modalMode, item) {
        $scope.modalMode = modalMode;
        if(item != null){
            $scope.item = item;
        }
            $('#modal').modal('toggle');
        }

       $scope.delete = function (id) {
           queryService.asyncDelete(constantService.EQUIPMENT_ITEMS_URL.concat("/").concat(id)).then(function () {
               getEquipmentItems();
           });
       };

       $scope.create = function (item) {
           queryService.asyncPost(constantService.EQUIPMENT_ITEMS_URL, item).then(function () {
               getEquipmentItems();
           });
       };

       $scope.update = function (item) {
           queryService.asyncPut(constantService.EQUIPMENT_ITEMS_URL, item).then(function () {
               getEquipmentItems();
           });
       };
       getEquipmentItems();
   };
})();