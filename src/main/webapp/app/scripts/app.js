

var app = angular.module('spotsApp',['ngRoute', 'ngCookies', 'spotsAppServices']);
  
  app.config(['$routeProvider', '$locationProvider', '$httpProvider', 
              function ($routeProvider, $locationProvider, $httpProvider) 
  {
	  $routeProvider.when('/home', { templateUrl: 'partials/home.html', controller: HomeController});
	   	
	  $routeProvider.when('/register', { templateUrl: 'partials/register.html', controller: RegisterController});
	    
	  $routeProvider.when('/login', { templateUrl: 'partials/login.html', controller: LoginController});
	  
	  $routeProvider.when('/profile', { templateUrl: 'partials/profile.html', controller: ProfileController});
	  
	  $routeProvider.when('/profileEdit', { templateUrl: 'partials/profileEdit.html', controller: ProfileEditController});

	  $routeProvider.when('/spots', { templateUrl: 'partials/spots.html', controller: SpotsController});
	  
	  $routeProvider.when('/spotSearch', { templateUrl: 'partials/spotsSearch.html', controller: SpotsSearchController});
	  
	  $routeProvider.when('/spotsCreate', { templateUrl: 'partials/spotsCreate.html', controller: SpotsCreateController}); 
	  
	  $routeProvider.when('/spotEdit/:spotId', { templateUrl: 'partials/spotEdit.html', controller: SpotEditController});
	  
	  $routeProvider.when('/spotShow/:spotId', { templateUrl: 'partials/spotShow.html', controller: SpotShowController});
	  
	  
	    
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
	    $httpProvider.interceptors.push(function ($q, $rootScope, $location, $log) {
	        return {
	        	'request': function(config) {
	        		var isRestCall = config.url.indexOf('rest') == 0;
	        		if (true && angular.isDefined($rootScope.authToken)) {
	        			var authToken = $rootScope.authToken;
	        			
	        			if (spotsAppConfig.useAuthTokenHeader) {
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
	  
	  
  
function RegisterController($scope, $location, $log, $http, registerService) 
{	  
	$scope.send = function(user)
    {
		if(registerService.checkPasswordEquals)
		{
			registerService.addUser(user);
		}
		else
		{
			
		}
    };
};
    
function LoginController($scope, $rootScope, $location, $cookieStore, UserService, $log, $http) {
	
	$scope.rememberMe = false;
	
	$scope.authMessage;
	
	$http.get('/version').
	  success(function(data, status, headers, config) {
		  $log.info('data '+JSON.stringify(data));
		  $rootScope.version = data;
		  
	    // this callback will be called asynchronously
	    // when the response is available
	  }).
	  error(function(data, status, headers, config) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	
	$scope.login = function() 
	{
		$scope.user.username;
		$scope.user.password;
		
		var authResponse = $http.post('/user/authenticate',$scope.user);
		
		authResponse.success(function(data, status, headers, config)
		{	    	    
			$log.info('$rootScope.authToken '+$rootScope.authToken);
			
			if(data.token === undefined){
				$log.info('Token undefined');
				
				$scope.authMessage = 'Username or Password wrong';
			}
			else{
				$rootScope.authToken = data.token;
			
				if ($scope.rememberMe) {
					$cookieStore.put('authToken', data.token);
				}
				
				UserService.get(function(user) {
					$rootScope.user = user;
					$location.path("/");
				});
			}
			
        });
		
	};
};

function ProfileController($scope,$log, $http)
{
	$scope.user;
	
	$http.get('/user/user').
	  success(function(data, status, headers, config) {
		  $log.info('data '+JSON.stringify(data));
		  $scope.user = data;
		  
	    // this callback will be called asynchronously
	    // when the response is available
	  }).
	  error(function(data, status, headers, config) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	
	
	
};

function SpotsController($scope, $log, $http){
	
	$scope.spots;
	
	$http.get('/spot/spots').
	  success(function(data, status, headers, config) {
		  $log.info('data '+JSON.stringify(data));
		  $scope.spots = data;
		  
	    // this callback will be called asynchronously
	    // when the response is available
	  }).
	  error(function(data, status, headers, config) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	
};

function SpotsSearchController(){
	
};

function SpotsCreateController ($scope, $log, $http){
	$scope.send = function(spot){
		$log.info('spot '+JSON.stringify(spot));
		
		$http.post('/spot/createSpot',spot);
		
		$location.path("/");
	};
	
};

function ProfileEditController ($scope, $log, $http){
	
	$scope.user;
	
	$http.get('/user/user/').
	  success(function(data, status, headers, config) {
		  $log.info('data '+JSON.stringify(data));
		  $scope.user = data;
		  $scope.user.password = '';
		  
	    // this callback will be called asynchronously
	    // when the response is available
	  }).
	  error(function(data, status, headers, config) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	
	$scope.send = function(){
		$http.post('/user/editUser',$scope.user);
	};
	
};

function SpotEditController ($scope, $log, $http, $routeParams){
	
	var spotId = $routeParams.spotId;
	
	$scope.spot;
	
	$http.get('/spot/spot/'+spotId).
	  success(function(data, status, headers, config) {
		  $log.info('data '+JSON.stringify(data));
		  $scope.spot = data;
		  
	    // this callback will be called asynchronously
	    // when the response is available
	  }).
	  error(function(data, status, headers, config) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });
	
	$scope.send = function(){
		$http.post('/spot/editSpot',$scope.spot);
	};
};



function SpotShowController ($scope, $log, $http, $routeParams){
	
	var spotId = $routeParams.spotId;
	
	$scope.spot;
	$scope.activities;

	$http.get('/spot/spot/'+spotId).
		success(function(data, status, headers, config) {
			$log.info('data '+JSON.stringify(data));
			$scope.spot = data;
	  
			// this callback will be called asynchronously
			// when the response is available
		}).
		error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	
	$http.get('/activity/activities/'+spotId).
	success(function(data, status, headers, config) {
		$log.info('data '+JSON.stringify(data));
		$scope.activities = data;
  
		// this callback will be called asynchronously
		// when the response is available
	}).
	error(function(data, status, headers, config) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
	});
}

function HomeController(){
	
};

var services = angular.module('spotsAppServices', ['ngResource']);

services.factory('UserService', function($resource) {
	
	return $resource('user/username/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded'}
				},
			}
		);
});

services.factory('registerService', function($http,$log) {
	
	return {
		checkPasswordEquals: function(user){
			return angular.equals(user.password, user.password1);
	   	},
	   	addUser: function(user){
	 
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
	
	
});
