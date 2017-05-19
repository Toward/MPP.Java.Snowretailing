(function () {
    angular.module("Snowretailing").controller("HeaderController", LoginController);

    function LoginController($rootScope, $scope, $location, userService, constantService) {
        $rootScope.isAuthorized = userService.isUserExist();
        $rootScope.currentUser = userService.getCurrentUser();

        $rootScope.equipmentsCostXLSX = constantService.EQUIPMENT_COST_XLSX;
        $rootScope.equipmentsCostCSV = constantService.EQUIPMENT_COST_CSV;
        $rootScope.equipmentsCostPDF = constantService.EQUIPMENT_COST_PDF;

        $rootScope.equipmentsListXLSX = constantService.EQUIPMENT_LIST_XLSX;
        $rootScope.equipmentsListCSV = constantService.EQUIPMENT_LIST_CSV;
        $rootScope.equipmentsListPDF = constantService.EQUIPMENT_LIST_PDF;

        $rootScope.clientsListXLSX = constantService.CLIENTS_LIST_XLSX;
        $rootScope.clientsListCSV = constantService.CLIENTS_LIST_CSV;
        $rootScope.clientsListPDF = constantService.CLIENTS_LIST_PDF;

        $rootScope.equipmentsItemsHistoryXLSX = constantService.EQUIPMENTS_ITEMS_HISTORY_XLSX;
        $rootScope.equipmentsItemsHistoryCSV = constantService.EQUIPMENTS_ITEMS_HISTORY_CSV;
        $rootScope.equipmentsItemsHistoryPDF = constantService.EQUIPMENTS_ITEMS_HISTORY_PDF;

        $scope.logout = function(){
            userService.removeUser();
            $rootScope.isAuthorized = false;
            $rootScope.currentUser = null;
            $location.path('/');
        }
    }
})();