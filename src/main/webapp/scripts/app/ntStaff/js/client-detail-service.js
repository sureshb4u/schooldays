(function () {
    'use strict';
    /**
     * @ngdoc service
     * @name atrium.service:clientDetailService
     * @description
     * # clientDetailService
     * Service in the atrium.
     */
    vApp.service('clientDetailService', ['$rootScope', '$resource', '$q', '$log', 'restService', 'LxNotificationService', function ($rootScope,
        $resource, $q, $log, restService, LxNotificationService) {

        /*
        * Service : getDashboardList
        * This service will retrieve the dashboard list
        */
    	
        this.getClientDetail = function () {
            var deferred = $q.defer();
  			var url ='/api/organization/organization/6c008300-8eef-4440-8a21-f57db1928e17';
  			var data = restService.restCall("",url,'GET');
			data.$promise.then(function(response){
				deferred.resolve(response);
			},
            function (error) {
                if (error.status == "401") {
                    $state.go('login');
                } else {
                    LxNotificationService.warning(error.data.Message);
                }
                deferred.reject('ajaxError');
            });
            return deferred.promise;
        };
        
        this.getClientProfile = function(){
            var deferred = $q.defer();
  			var url ='/api/client/getClientProfile';
  			var data = restService.restCall("",url,'GET');
			data.$promise.then(function(response){
				deferred.resolve(response);
			},
            function (error) {
                if (error.status == "401") {
                    $state.go('login');
                } else {
                    LxNotificationService.warning(error.data.Message);
                }
                deferred.reject('ajaxError');
            });
            return deferred.promise;
        }
        
    }]);

})();
