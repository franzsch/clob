

var app = angular.module('spotsApp',['ngRoute', 'ngCookies', 'spotsService']);
  
  app.config(['$routeProvider', '$locationProvider', '$httpProvider', 
              function ($routeProvider, $locationProvider, $httpProvider) 
  {
	   	
	  $routeProvider.when('/register', { templateUrl: 'partials/register.html', controller: RegisterController});
	    
	  $routeProvider.when('/login', { templateUrl: 'partials/login.html', controller: LoginController});
	    
	  $routeProvider.otherwise({redirectTo: '/'});
	  
	  
	  
	  /* Register error provider that shows message on failed requests or redirects to login page on
		 * unauthenticated requests */
	    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'responseError': function(rejection) {
		        		var status = rejection.status;
		        		var config = rejection.config;
		        		var method = config.method;
		        		var url = config.url;
		      
		        		if (status == 401) {
		        			$location.path( "/login" );
		        		} else {
		        			$rootScope.error = method + " on " + url + " failed with status " + status;
		        		}
		              
		        		return $q.reject(rejection);
		        	}
		        };
		    }
	    );
	    
	    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
	     * as soon as there is an authenticated user */
	    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
	        return {
	        	'request': function(config) {
	        		var isRestCall = config.url.indexOf('rest') == 0;
	        		if (isRestCall && angular.isDefined($rootScope.authToken)) {
	        			var authToken = $rootScope.authToken;
	        			if (exampleAppConfig.useAuthTokenHeader) {
	        				config.headers['X-Auth-Token'] = authToken;
	        			} else {
	        				config.url = config.url + "?token=" + authToken;
	        			}
	        		}
	        		return config || $q.when(config);
	        	}
	        };
	    }
  );
	   
	} ]
	
).run(function($rootScope, $location, $cookieStore, UserService) {
	
	/* Reset error when a new view is loaded */
	$rootScope.$on('$viewContentLoaded', function() {
		delete $rootScope.error;
	});
	
	$rootScope.hasRole = function(role) {
		
		if ($rootScope.user === undefined) {
			return false;
		}
		
		if ($rootScope.user.roles[role] === undefined) {
			return false;
		}
		
		return $rootScope.user.roles[role];
	};
	
	$rootScope.logout = function() {
		delete $rootScope.user;
		delete $rootScope.authToken;
		$cookieStore.remove('authToken');
		$location.path("/login");
	};
	
	 /* Try getting valid user from cookie or go to login page */
	var originalPath = $location.path();
	$location.path("/login");
	var authToken = $cookieStore.get('authToken');
	if (authToken !== undefined) {
		$rootScope.authToken = authToken;
		UserService.get(function(user) {
			$rootScope.user = user;
			$location.path(originalPath);
		});
	}
	
	$rootScope.initialized = true;
});
	  
 // }]);
	  
	  
  
function RegisterController($scope, $location, $log, $http) 
{	  
	$scope.send = function(user)
    {
		if(angular.equals(user.password, user.password1))
        {
			var addUserPost = $http.post('/user/addUser',user);
            
            addUserPost.success(function(data, status, headers, config)
            {
            	$log.info('data '+JSON.stringify(data));
            	$log.info('status '+status);
            	$log.info('headers '+headers);
               	$log.info('config '+JSON.stringify(config));
            });
            
            addUserPost.error(function(data, status, headers, config) 
            {
            	$log.info('data '+JSON.stringify(data));
            	$log.info('status '+status);
            	$log.info('headers '+headers);
            	$log.info('config '+JSON.stringify(config));
    		});
          }    
       };
};
    
function LoginController($scope, $rootScope, $location, $cookieStore, UserService, $log, $http) {
	
	$scope.rememberMe = false;
	
	$scope.login = function() 
	{
		$scope.user.username;
		$scope.user.password;
		
		var authResponse = $http.post('/user/authenticate',$scope.user);
		
		var authToken;
		
		authResponse.success(function(data, status, headers, config)
		{
			$log.info('data '+JSON.stringify(data));
		    $log.info('status '+status);
		    $log.info('headers '+headers);
		    $log.info('config '+JSON.stringify(config));
		    
		    $log.info('data.token '+data.token);
		    
		    authToken = data.token;
		    
		    $log.info('authToken '+authToken);
			$rootScope.authToken = authToken;
			if ($scope.rememberMe) {
				$cookieStore.put('authToken', authToken);
			}
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path("/");
			});
        });
		
	};
};

  

    


    

