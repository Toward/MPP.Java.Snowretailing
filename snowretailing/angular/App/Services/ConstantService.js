(function () {
   angular.module("Snowretailing").service("constantService", function () {
       var BASE_URL = "http://192.168.43.216:8080/";
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
           // DOCUMENTS
           EQUIPMENT_COST_XLSX : BASE_URL.concat('documents/equipmentsCost/xlsx'),
           EQUIPMENT_COST_CSV : BASE_URL.concat('documents/equipmentsCost/csv'),
           EQUIPMENT_COST_PDF : BASE_URL.concat('documents/equipmentsCost/pdf'),

           EQUIPMENT_LIST_XLSX : BASE_URL.concat('documents/equipmentsList/xlsx'),
           EQUIPMENT_LIST_CSV : BASE_URL.concat('documents/equipmentsList/csv'),
           EQUIPMENT_LIST_PDF : BASE_URL.concat('documents/equipmentsList/pdf'),

           CLIENTS_LIST_XLSX : BASE_URL.concat('documents/clientsList/xlsx'),
           CLIENTS_LIST_CSV : BASE_URL.concat('documents/clientsList/csv'),
           CLIENTS_LIST_PDF : BASE_URL.concat('documents/clientsList/pdf'),

           EQUIPMENTS_ITEMS_HISTORY_XLSX : BASE_URL.concat('documents/equipmentsItemsHistory/1/xlsx'),
           EQUIPMENTS_ITEMS_HISTORY_CSV : BASE_URL.concat('documents/equipmentsItemsHistory/1/csv'),
           EQUIPMENTS_ITEMS_HISTORY_PDF : BASE_URL.concat('documents/equipmentsItemsHistory/1/pdf'),
       };
   });
})();
