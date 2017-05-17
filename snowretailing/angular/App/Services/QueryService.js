(function () {
    angular.module("Snowretailing").service("queryService", function ($q, $http, userService) {
        return {
            asyncGet : function (url) {
                var deffered = $q.defer();

                $http.get(url, {headers:{"Token":userService.getToken()}}).then(function (response) {
                    if(response.data.resultStatus == "OK"){
                        deffered.resolve(response.data.data);
                    }else{
                        deffered.reject(response.data.message);
                    }
                }, function (responce) {
                    deffered.reject("No connection to the server");
                })
                return deffered.promise;
            },

            asyncPost : function (url, data) {
                var deffered = $q.defer();

                $http.post(url, data, {headers:{"Token":userService.getToken()}}).then(function (response) {
                    if(response.data.resultStatus == "OK"){
                        deffered.resolve(response.data.data);
                    }else{
                        deffered.reject(response.data.message);
                    }
                }, function (responce) {
                    deffered.reject("No connection to the server");
                })
                return deffered.promise;
            }
        };
    });
})();

