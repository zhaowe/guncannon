'use strict';

describe('plantList', function() {

  // Load the module that contains the `plantList` component before each test
  beforeEach(module('plantList'));

  // Test the controller
  describe('PlantListController', function() {
    var $httpBackend, ctrl;

    beforeEach(inject(function($componentController, _$httpBackend_) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('plants/plants.json')
                  .respond([{name: 'Nexus S'}, {name: 'Motorola DROID'}]);

      ctrl = $componentController('plantList');
    }));

    it('should create a `plants` property with 2 plants fetched with `$http`', function() {
      jasmine.addCustomEqualityTester(angular.equals);

      expect(ctrl.plants).toEqual([]);

      $httpBackend.flush();
      expect(ctrl.plants).toEqual([{name: 'Nexus S'}, {name: 'Motorola DROID'}]);
    });

    it('should set a default value for the `orderProp` property', function() {
      expect(ctrl.orderProp).toBe('age');
    });

  });

});
