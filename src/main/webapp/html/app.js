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
          }
          
          $http.get('/user/user.json').success(function(data){
         	 
         	testUser.user = data;
         	$log.info('Get Data' +JSON.stringify(data));  
           });
          
          $log.info('testUser.test '+JSON.stringify(testUser.user));
          
          $http.post('/user/addUser',testUser.user).success(function(){
        	  
        	  
          });
          
        
          
        };
      }],controllerAs: 'userCtrl'
    };

  });


})();
