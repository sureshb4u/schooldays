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
        
	  $scope.engagementDetails = function(){
		  $scope.rightQuestions = [];
		  $scope.leftQuestions = [];
		  var data = dashboardDetailService.getengagementDetails();
		  data.then(function(success){
			  $scope.engagementDetailsList = success;
			  var num1 = ($scope.engagementDetailsList.engagementQuestions.length)/2;
			  for(var num=0;num<$scope.engagementDetailsList.engagementQuestions.length;num++){
				  if($scope.engagementDetailsList.engagementQuestions[num].qno>num1.toFixed()){
					  $scope.rightQuestions.push($scope.engagementDetailsList.engagementQuestions[num]);
				  }else{
					  $scope.leftQuestions.push($scope.engagementDetailsList.engagementQuestions[num]);
				  }
			  }
		  });
	  };
	  
    }]);
})();