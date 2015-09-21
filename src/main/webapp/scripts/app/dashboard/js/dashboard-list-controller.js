(function () {
    'use strict';

    /**
     * @ngdoc function
     * @name atrium.controller:dashboardListController
     * @description
     * # dashboardListController
     * Controller of the atrium
     */

    vApp.controller('dashboardListController', ['$scope', '$q', '$compile', '$log', 'restService', 'dashboardListService', '$timeout',
    		     function ($scope, $q, $compile, $log, restService, dashboardListService,$timeout) {

        /*
        * Controller : loadDashboardList
        * State: ""
        * This controller will retrieve and display the dashboard list
        */
        
/*  	  $scope.loadDashboardList = function() {
          var data = dashboardListService.getDashboardList();
          data.then(function (success) {
        	  console.log("success111--------->>>>>>"+JSON.stringify(success));
        	  $scope.dashboardList = success;
          });
	  };*/
	  
	  $scope.loadInboxList = function() {
          var data = dashboardListService.getInboxList();
		  data.then(function(success){
			  $scope.inboxList = success;
			  $timeout(function() {
	    			 if($scope.ids != ""){
	    				 angular.element(".title#"+ids[0]).trigger('click');
	    			 }
	 	     }, 100);
		  });
	  };
	  
	  $scope.loadActivityList = function() {
          var data = dashboardListService.getActivityList();
          data.then(function (success) {
        	  $scope.activityList = success;
          });
	  };
	  
	  $scope.loadEvaluationList = function() {
          var data = dashboardListService.getEvaluationList();
          data.then(function (success) {
        	  $scope.evaluationList = success;
          });
	  };
	  
    }]);
})();