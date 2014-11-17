(function(){

  var app = angular.module('user',['ngRoute']);
  
  app.config(function ($routeProvider) {
	    $routeProvider
	        .when('/', {
	            templateUrl: 'partials/register.html',
	            controller: RegisterController
	        })
	        .otherwise({
	            redirectTo: '/'
	        });
	});
  
  function RegisterController($scope, $location) {
		
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
	};
})();
