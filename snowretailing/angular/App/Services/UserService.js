(function() {
    angular.module("Snowretailing").service("userService", TokenService);

    function TokenService() {
        return{
            setUser : function (user) {
                var storedParams = {
                    userId: user.userId,
                    role: user.role.roleName,
                    login : user.login,
                    token: user.token
                }
                localStorage.setItem("User", JSON.stringify(storedParams));
            },

            getCurrentUser : function () {
                return JSON.parse(localStorage.getItem("User"));
            },

            getToken : function () {
                var user = JSON.parse(localStorage.getItem("User"));
                if(user == null)
                    return null;
                return user.token;
            },

            getRole: function () {
                var user = JSON.parse(localStorage.getItem("User"));
                if(user == null)
                    return null;
                return user.role;
            },

            getLogin: function () {
                var user = JSON.parse(localStorage.getItem("User"));
                if(user == null)
                    return null;
                return user.login;
            },

            getUserId:function () {
                var user = JSON.parse(localStorage.getItem("User"));
                if(user == null)
                    return null;
                return user.userId;
            },

            removeUser : function () {
                localStorage.removeItem("User");
            },

            isUserExist: function () {
                return !(localStorage.getItem("User") === null);
            }
        }
    }
})();