(function () {
   angular.module("Snowretailing").service("constantService", function () {
       var BASE_URL = "http://localhost:8080/"
       return{
           EQUIPMENTS_GET_URL : BASE_URL.concat("equipments"),
           REVIEWS_GET_URL : BASE_URL.concat("reviews"),
           LOGIN_URL : BASE_URL.concat("auth/login"),
           REGISTER_URL : BASE_URL.concat("auth/register"),
           CHANGE_PASSWORD_URL : BASE_URL.concat("/api/auth/editPassword"),
           BRANDS_GET_URL : BASE_URL.concat("api/brands"),
           CLIENTS_GET_URL : BASE_URL.concat("api/credentials"),
           EQUIPMENT_ITEMS_GET_URL : BASE_URL.concat("api/equipment_items"),
           TYPES_GET_URL : BASE_URL.concat("api/types"),
           ORDERS_GET_URL : BASE_URL.concat("api/orders"),
           RENTS_GET_URL : BASE_URL.concat("api/rents"),
           USERS_URL : BASE_URL.concat("/api/users")
       };
   });
})();
