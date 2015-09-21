(function () {
    'use strict';

    /**
     * @ngdoc function
     * @name atrium.controller:workerListController
     * @description
     * # workerListController
     * Controller of the atrium
     */

    vApp.controller('workerListController', ['$scope', '$q', '$compile', '$log', 'restService', 'workerListService', '$timeout',
    		     function ($scope, $q, $compile, $log, restService, workerListService,$timeout) {

        /*
        * Controller : loadDashboardList
        * State: ""
        * This controller will retrieve and display the dashboard list
        */
	  
      $scope.getWorkerList = function(){
		  var data = workerListService.loadWorkerList();
		  data.then(function(success){
			  $scope.workerList = success;
		  });
      };
	  
    }]);
})();