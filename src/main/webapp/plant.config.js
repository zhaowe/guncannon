'use strict';

angular.
  module('plantcatApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/plantlist', {
          template: '<plant-list></plant-list>'
        }).
        when('/plant/:plantId', {
          template: '<plant-detail></plant-detail>'
        }).
        otherwise('/plantlist');
    }
  ]);
