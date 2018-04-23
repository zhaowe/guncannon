'use strict';

// Register `plantList` component, along with its associated controller and template
angular.
  module('plantList').
  component('plantList', {
    templateUrl: 'plant-list/plant-list.template.html',
      controller: function PlantListController($http) {
	  var self = this;
	  this.isReverse = false;
	  this.orderProp = "purchasingDate";

	  $http.get("/guncannon/plants-list").then(function(response) {
	      self.plants = response.data;
	  });
      }
  });
