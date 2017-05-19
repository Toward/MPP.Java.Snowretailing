(function () {
    angular.module("Snowretailing", ["ngRoute"])
        .config(function ($routeProvider) {
            $routeProvider.when("/",{
                templateUrl: "App/Templates/HomePage.html"
            });

            $routeProvider.when("/login",{
                templateUrl: "App/Templates/LoginPage.html"
            });

            $routeProvider.when("/register",{
                templateUrl: "App/Templates/RegisterPage.html"
            });

            $routeProvider.when("/brands",{
                templateUrl: "App/Templates/BrandsPage.html"
            });

            $routeProvider.when("/clients",{
                templateUrl: "App/Templates/ClientsPage.html"
            });

            $routeProvider.when("/equipment_items",{
                templateUrl: "App/Templates/EquipmentItemsPage.html"
            });

            $routeProvider.when("/types",{
                templateUrl: "App/Templates/TypesPage.html"
            });

            $routeProvider.when("/rents",{
                templateUrl: "App/Templates/RentsPage.html"
            });

            $routeProvider.when("/orders",{
                templateUrl: "App/Templates/OrdersPage.html"
            });

            $routeProvider.otherwise("/");
        });
})();