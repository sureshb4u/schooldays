(function() {
  'use strict';
/**
 * @ngdoc function
 * @name atrium.controller:workerController
 * @description
 * # workerController
 * Controller of the atrium
 */
  vApp.controller('workerController', [ '$scope','$translate','restService','$translatePartialLoader','$log','$location','$timeout','$controller', function($scope,$translate,restService,$translatePartialLoader,$log,$location,$timeout,$controller) {
	  $translate.refresh();
	    var tabs = [
	                { title: 'Profile', content: "scripts/app/worker/view/profile.html"},
	                { title: 'Engagements',content: "scripts/app/worker/view/engagements.html"},
	                { title: 'Documents',content: "scripts/app/worker/view/documents.html"},
	              ],
	              selected = null,
	              previous = null;
	          $scope.tabs = tabs;
	          $scope.selectedIndex = 2;
	          angular.extend(this, $controller('workerListController', { $scope: $scope }));
	          angular.extend(this, $controller('workerDetailController', { $scope: $scope }));
	          
	          $scope.$watch('selectedIndex', function(current, old){
	            previous = selected;
	            selected = tabs[current];
	            if ( old + 1 && (old != current)) $log.debug('Goodbye ' + previous.title + '!');
	            if ( current + 1 )                $log.debug('Hello ' + selected.title + '!');
	          });
	          $scope.tabNavigation=function(tabLabel){
	        	$scope.mainTemplate('details',tabLabel.toLowerCase());
	          };
	          
	          $scope.mainTemplate = function(type1,type2){
	  	    		$scope.template1={
	  						     "pageList":"scripts/app/worker/view/"+type1+".html",
	  						     "pageDetails":"scripts/app/worker/view/"+type2+".html"
	  						   };  
	  				   angular.element(".org-details-title .dropdown").show();
	  			};
	} ]);
 })(); 