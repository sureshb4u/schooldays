/**
 *  Profile Controller
 */

(function() {
  'use strict';
/**
 * @ngdoc function
 * @name atrium.controller:dashboardCtrl
 * @description
 * # dashboardCtrl
 * Controller of the atrium
 */
  vApp.controller('lmsController', [ '$scope','$translate','restService','$translatePartialLoader','$log','$location','$timeout','$controller',
                                 function($scope, $translate, restService, $translatePartialLoader, $log, $location, $timeout, $controller) {
	  
	  $translate.refresh();
	  $scope.ids = [];
	  
	  if(localStorage.getItem("queryparam") != ""){
		  var orgId = localStorage.getItem("queryparam").split('&');
		  for(var i=0;i<orgId.length;i++){
			  $scope.ids.push(orgId[i].split('=')[1]);
		  }
	  }
	
	  $scope.mainTemplate = function(type1,type2){
		  console.log('type2-------------'+type2);
	    		$scope.template1={
						  //   "pageList":"scripts/app/dashboard/view/"+type1+".html",
						     "pageDetails":"scripts/app/lms/view/"+type2+".html"
						   };  
			};
	  
	  $scope.openDeclrations = function(){
		  $timeout(function(){
			  $scope.opendDialog('questions');
		  },500);
	  };
	  
	  	$scope.orightml = '<p>Hello</p>';
		$scope.htmlcontent = "Hello";
		$scope.disabled = false;
		
		$scope.user = {
				firstName :'Vignesh',
				lastName : 'Periyanayagam',
				email : 'viki19nesh@gmail.com',
				designation : 'Junior Software Developer',
				address : 'madurai',
				contacts : '9629400474',
				biography : 'First WebApp with Angular'
		}
		
	} ]);
 })(); 
