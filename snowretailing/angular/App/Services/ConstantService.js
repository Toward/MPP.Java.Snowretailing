(function () {
   angular.module("Snowretailing").service("constantService", function () {
       var BASE_URL = "http://172.20.10.7:8080/"
       return{
           EQUIPMENTS_GET_URL : BASE_URL.concat("equipments"),
           EQUIPMENTS_POST_URL : BASE_URL.concat("api/equipments"),
           REVIEWS_GET_URL : BASE_URL.concat("reviews"),
           LOGIN_URL : BASE_URL.concat("auth/login"),
           REGISTER_URL : BASE_URL.concat("auth/register"),
           CHANGE_PASSWORD_URL : BASE_URL.concat("/api/auth/editPassword"),
           BRANDS_URL : BASE_URL.concat("api/brands"),
           CLIENTS_URL : BASE_URL.concat("api/credentials"),
           EQUIPMENT_ITEMS_URL : BASE_URL.concat("api/equipment_items"),
           TYPES_URL : BASE_URL.concat("api/types"),
           ORDERS_URL : BASE_URL.concat("api/orders"),
           RENTS_URL : BASE_URL.concat("api/rents"),
           USERS_URL : BASE_URL.concat("/api/users"),
           REVIEW_USERS_URL : BASE_URL.concat("/api/user_reviews"),
           REVIEW_ADMIN_URL : BASE_URL.concat("/api/reviews"),
       };
   });
})();
