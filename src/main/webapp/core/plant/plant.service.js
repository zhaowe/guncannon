'use strict';

angular.
  module('core.plant').
  factory('Plant', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/plants/:plantId.json', {}, {
        query: {
          method: 'GET',
          params: {plantId: 'plants'},
          isArray: true
        }
      });
    }
  ]);
