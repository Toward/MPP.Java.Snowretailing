(function () {
   angular.module("Snowretailing").controller("ClientController", ClientController);

   function ClientController($scope,queryService,constantService) {
       getClients = function () {
           queryService.asyncGet(constantService.CLIENTS_URL).then(function (response) {
               $scope.clients = response;
           });
       };

       $scope.showModal = function (modalMode, client) {
        $scope.modalMode = modalMode;
        if(client != null){
            $scope.client = client;
        }
            $('#modal').modal('toggle');
        };

       $scope.delete = function (id) {
           queryService.asyncDelete(constantService.CLIENTS_URL.concat("/").concat(id)).then(function () {
               getClients();
           });
       };

       $scope.create = function (client) {
           queryService.asyncPost(constantService.CLIENTS_URL, client).then(function () {
               getClients();
           });
       };

       $scope.update = function (client) {
           queryService.asyncPut(constantService.CLIENTS_URL, client).then(function () {
               getClients();
           });
       };
       getClients();
   };
})();
