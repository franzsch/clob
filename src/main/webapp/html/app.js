(function(){

  var app = angular.module('user',[ ]);



  app.directive('userRegister', function(){
    return {
      restrict: 'E',
      templateUrl: 'user-register.html',
      controller: function() {
        this.user = {};

        this.addUser = function(user)
        {
          this.user.passwordEquals = false;

          if(angular.equals(user.password1, user.password2))
          {
            this.user = angular.copy(user);
            this.user.passwordEquals = true;
          }
        };
      },controllerAs: 'userCtrl'
    };

  });


})();
