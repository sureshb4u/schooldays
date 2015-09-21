(function() {
  'use strict';
/**
 * @ngdoc function
 * @name atrium.controller:dashboardCtrl
 * @description
 * # dashboardCtrl
 * Controller of the atrium
 */
  vApp.controller('dashboardCtrl', [ '$scope','$translate','restService','$translatePartialLoader','$log','$location','$timeout','$controller',
                                 function($scope, $translate, restService, $translatePartialLoader, $log, $location, $timeout, $controller) {
	  
	  $translate.refresh();
	  angular.extend(this, $controller('dashboardListController', { $scope: $scope }));
	  angular.extend(this, $controller('dashboardDetailController', { $scope: $scope }));
	  $scope.ids = [];
	  
	  if(localStorage.getItem("queryparam") != ""){
		  var orgId = localStorage.getItem("queryparam").split('&');
		  for(var i=0;i<orgId.length;i++){
			  $scope.ids.push(orgId[i].split('=')[1]);
		  }
	  }
	  $scope.mainTemplate = function(type1,type2){
		  console.log("type1---"+type1+"----type2-----------"+type2);
	    		$scope.template1={
						     "pageList":"scripts/app/dashboard/view/"+type1+".html",
						     "pageDetails":"scripts/app/dashboard/view/"+type2+".html"
						   };  
	    		console.log($scope.template1.pageDetails);
				   angular.element(".org-details-title .dropdown").show();
			};
	  
	  $scope.openDeclrations = function(){
		  $timeout(function(){
			  $scope.opendDialog('questions');
		  },500);
	  };
	  
	  $scope.scrollFun=function(lxdialogId){
			  if(lxdialogId == 'engagement'){
				  return "scrollDiv";
			  }
		  };
	  	$scope.orightml = '<p>Hello</p>';
		$scope.htmlcontent = "Hello";
		$scope.disabled = false;
		
	} ]);
 })(); 