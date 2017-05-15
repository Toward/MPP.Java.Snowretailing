(function () {
    angular.module("Snowretailing").service("queryService", function ($q, $http) {
        return{
            asyncGet : function (url, token) {
                var deffered = $q.defer();

                $http.get(url, {headers:{"Token":token}}).then(function (response) {
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

