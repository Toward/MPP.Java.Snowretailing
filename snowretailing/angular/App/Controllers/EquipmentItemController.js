(function () {
   angular.module("Snowretailing").controller("EquipmentItemController", EquipmentItemController);

   function EquipmentItemController($scope,queryService,constantService) {
       queryService.asyncGet(constantService.EQUIPMENT_ITEMS_GET_URL).then(function (response) {
         $scope.items = response;
       });
   };
})();