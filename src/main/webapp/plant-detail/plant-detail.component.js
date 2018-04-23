'use strict';

// Register `plantDetail` component, along with its associated controller and template
angular.
  module('plantDetail').
  component('plantDetail', {
    templateUrl: 'plant-detail/plant-detail.template.html',
      controller: ['$routeParams', '$http',
		   function PlantDetailController($routeParams, $http) {
		       var self = this;
		       $http.get("/guncannon/plant?id="+$routeParams.plantId)
			   .then(function(response) {
			       self.plant = response.data;
			   });
		   }
		  ]
  });
