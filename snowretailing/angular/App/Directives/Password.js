(function () {
    angular.module("Snowretailing").directive('password', function() {
        return {
            require: 'ngModel',
            link: function(scope, element, attr, ctrl) {
                function validation(value) {
                    if (value.length <= 20 && value.length >= 3) {
                        ctrl.$setValidity('length', true);
                    } else {
                        ctrl.$setValidity('length', false);
                    }
                    return value;
                }
                ctrl.$parsers.push(validation);
            }
        };
    });
})();