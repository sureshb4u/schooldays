(function(){
	'use strict';
	/**
	 * @ngdoc service
	 * @name atrium.factory:clientService
	 * @description
	 * # clientService
	 * Factory in the atrium.
	 */
	 /** @ngInject */
	vApp.factory('clientService', function() {
		 var savedData = {};
		 function set(data) {
		   savedData = data;
		 }
		 function get() {
		  return savedData;
		 }

		 return {
		  setDetails: set,
		  getDetails: get
		 };

		});
}());