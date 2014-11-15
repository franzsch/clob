(function(){

  var app = angular.module('user',[ ]);

  app.directive('userRegister', function(){
    return {
      restrict: 'E',
      templateUrl: 'user-register.html',
      controller: ['$http','$log', function($http,$log) {
        this.user = {};
        var testUser = this;

        this.addUser = function(user, password)
        {
          if(angular.equals(password.first, password.secound))
          {
        	user.password = password.first;
            this.user = angular.copy(user);
            
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
      }],controllerAs: 'userCtrl'
    };

  });


})();
