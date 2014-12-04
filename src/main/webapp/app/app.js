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
  
  function RegisterController($scope, $location, $log, $http) {
	  
	  $scope.send = function(user)
      {
          if(angular.equals(user.password1, user.password2))
          {
            var addUserPost = $http.post('/user/addUser',user);
            
            addUserPost.success(function(data, status, headers, config){
            	$log.info('data '+JSON.stringify(data));
            	$log.info('status '+status);
            	$log.info('headers '+headers);
               	$log.info('config '+JSON.stringify(config));
            });
            
            addUserPost.error(function(data, status, headers, config) {
            	$log.info('data '+JSON.stringify(data));
            	$log.info('status '+status);
            	$log.info('headers '+headers);
            	$log.info('config '+JSON.stringify(config));
    		});
          }    
        };
    };
})();
