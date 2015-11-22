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
        
	  $scope.studentCreate=function(){
		  var data = dashboardDetailService.getStudentCreate();
		  data.then(function (success){
			  var studentCreate=success;
		 });
	  }
	  
    }]);
})();