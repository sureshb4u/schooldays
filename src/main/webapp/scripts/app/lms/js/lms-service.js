(function () {
    'use strict';
    /**
     * @ngdoc service
     * @name atrium.service:clientDetailService
     * @description
     * # clientDetailService
     * Service in the atrium.
     */
    vApp.service('lmsService', ['$rootScope', '$resource', '$q', '$log', 'restService', 'LxNotificationService', function ($rootScope,
        $resource, $q, $log, restService, LxNotificationService) {

       
    	
    	this.createLeaveRequest = function (lms){
    		  var url ='api/lms/createRequest';
    		  $rootScope.master = angular.copy(lms);
    		  var deferred = $q.defer();
    		  var data = restService.restCall($rootScope.master, url, 'POST');
    		  data.$promise.then(function(response){
    				deferred.resolve(response);
    		  },
    		  function(error){
    			  LxNotificationService.warning(error);
    		  });
    		  return deferred.promise;
        }
    	
    }]);

})();
