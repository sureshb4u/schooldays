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
	  $scope.status = 'Absent';
	  
	  $scope.loadStudentsList = function(standardId, sectionId) {
		  console.log('loadStudentsList----------')
		  $scope.loader = true;
          var data = dashboardListService.getStudentsList(standardId, sectionId);
		  data.then(function(success){
			  console.log(angular.toJson(success));
			  $scope.students = success;
			  //$scope.mainTemplate('','list');
			  setTimeout(function(){
				  $scope.loader = false;
			  },1000);
		  });
	  };
	 
	  $scope.selectedTab=0;
	  
	  $scope.loadClassList =function(){
		  var data = dashboardListService.getClassList();
		  data.then(function(success){
			  console.log(angular.toJson(success));
			  $scope.classList = success;
		  })
	  }
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