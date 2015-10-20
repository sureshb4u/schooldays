(function () {
    'use strict';
    /**
     * @ngdoc service
     * @name atrium.service:clientDetailService
     * @description
     * # clientDetailService
     * Service in the atrium.
     */
    vApp.service('ntStaffservice', ['$rootScope', '$resource', '$q', '$log', 'restService', 'LxNotificationService', function ($rootScope,
        $resource, $q, $log, restService, LxNotificationService) {

        /*
        * Service : getDashboardList
        * This service will retrieve the dashboard list
        */
    	this.createStaff = function(obj){
    		console.log('service------------>'+JSON.stringify(obj));
    	    $rootScope.master = angular.copy(obj);
    		var deferred = $q.defer();
  		    var url = "/api/staff/createStaff";
  		    var data = restService.restCall($rootScope.master, url, 'POST');
			data.$promise.then(function(response){
				deferred.resolve(response);
			},
			function(error){
				alert(error);
			});
            return deferred.promise;
		};
    	
        
    }]);

})();
