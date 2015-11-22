(function () {
    'use strict';

    /**
     * @ngdoc function
     * @name atrium.controller:dashboardDetailController
     * @description
     * # dashboardDetailController
     * Controller of the atrium
     */

    vApp.controller('dashboardDetailController', ['$scope', '$q', '$compile', '$log', 'restService', 'dashboardDetailService', 
       function ($scope, $q, $compile, $log, restService, dashboardDetailService) {

        /*
        * Controller : getEventDetail
        * State: ""
        * This controller will retrieve and display the dashboard list
        */
     $scope.student ={};   
	  $scope.studentCreate=function(student){
		  console.log('student--------'+angular.toJson($scope.student));
		  var data = dashboardDetailService.getStudentCreate($scope.student);
		  data.then(function (success){
			  var studentCreate=success;
		 });
	  }
	  
    }]);
})();