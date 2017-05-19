(function () {
   angular.module("Snowretailing").service("constantService", function () {
       var BASE_URL = "http://192.168.2.134:8080/"
       return{
           EQUIPMENTS_GET_URL : BASE_URL.concat("equipments"),
           REVIEWS_GET_URL : BASE_URL.concat("reviews"),
           LOGIN_URL : BASE_URL.concat("auth/login"),
           REGISTER_URL : BASE_URL.concat("auth/register"),
           BRANDS_URL : BASE_URL.concat("api/brands"),
           CLIENTS_URL : BASE_URL.concat("api/credentials"),
           EQUIPMENT_ITEMS_URL : BASE_URL.concat("api/equipment_items"),
           TYPES_URL : BASE_URL.concat("api/types"),
           ORDERS_URL : BASE_URL.concat("api/orders"),
           RENTS_URL : BASE_URL.concat("api/rents"),
           LOGIN_URL : BASE_URL.concat("/auth/login"),
           REGISTER_URL : BASE_URL.concat("/auth/register"),
           USERS_URL : BASE_URL.concat("/api/users")
       };
   });
})();
