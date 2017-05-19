(function () {
   angular.module("Snowretailing").controller("HomeController", HomeController);
   
   function HomeController($scope,queryService,constantService, userService) {
       getEquipments = function () {
           queryService.asyncGet(constantService.EQUIPMENTS_GET_URL).then(function (response) {
               $scope.equipments = response;
           });
       };

              getTypes = function () {
           queryService.asyncGet(constantService.TYPES_URL).then(function (response) {
               $scope.types = response;
           });
       };

                     getBrands = function () {
           queryService.asyncGet(constantService.BRANDS_URL).then(function (response) {
               $scope.brands = response;
           });
       };

       getReviews = function() {
           $scope.isAuthorized = userService.isUserExist();
           queryService.asyncGet(constantService.REVIEWS_GET_URL).then(function (response) {
               $scope.reviews = response;
           });
       };

       $scope.showModal = function (modalMode, equipment) {
            $scope.modalMode = modalMode;
            if(equipment != null){
                $scope.equipment = equipment;
            }
            $('#modal').modal('toggle');
        };

        $scope.delete = function (id) {
            queryService.asyncDelete(constantService.EQUIPMENTS_POST_URL.concat("/").concat(id)).then(function () {
                getEquipments();
            });
        };

        $scope.create = function (equipment) {
            equipment.quantity = 0;
            equipment.cost = 10;
            queryService.asyncPost(constantService.EQUIPMENTS_POST_URL, equipment).then(function () {
                getEquipments();
            });
        };

        $scope.update = function (equipment) {
            queryService.asyncPut(constantService.EQUIPMENTS_POST_URL.concat("/").concat(equipment.id), equipment).then(function () {
                getEquipments();
            });
        };


                $scope.deleteReview = function (id) {
            queryService.asyncDelete(constantService.REVIEW_ADMIN_URL.concat("/").concat(id)).then(function () {
                getReviews();
            });
        };

        $scope.createReview = function (review) {
            queryService.asyncPost(constantService.REVIEW_USERS_URL, review).then(function () {
                getReviews();
            });
        };

        $scope.updateReview = function (review) {
            queryService.asyncPut(constantService.REVIEW_ADMIN_URL, review).then(function () {
                getReviews();
            });
        };

        $scope.showModalReview = function (modalMode, review) {
            $scope.modalMode = modalMode;
            if(review != null){
                $scope.review = review;
            }
            $('#modal-review').modal('toggle');
        };



        getEquipments();
        getReviews();
       getTypes();
       getBrands();

   };
})();