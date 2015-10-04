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
	  
      $scope.loadStaffList = function(){
    	  console.log('sadasdasfa');
		  var data = workerListService.loadWorkerList();
		  data.then(function(success){
			  $scope.staffList = success;
		  });
		  
		  
      };
	  
    }]);
})();