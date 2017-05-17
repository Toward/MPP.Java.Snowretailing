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

            $routeProvider.otherwise("/");
        });
})();