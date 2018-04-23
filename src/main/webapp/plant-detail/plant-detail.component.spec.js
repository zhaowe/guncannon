'use strict';

describe('plantDetail', function() {

  // Load the module that contains the `plantDetail` component before each test
  beforeEach(module('plantDetail'));

  // Test the controller
  describe('PlantDetailController', function() {
    var $httpBackend, ctrl;
    var xyzPlantData = {
      name: 'plant xyz',
      images: ['image/url1.png', 'image/url2.png']
    };

    beforeEach(inject(function($componentController, _$httpBackend_, $routeParams) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('plants/xyz.json').respond(xyzPlantData);

      $routeParams.plantId = 'xyz';

      ctrl = $componentController('plantDetail');
    }));

    it('should fetch the plant details', function() {
      jasmine.addCustomEqualityTester(angular.equals);

      expect(ctrl.plant).toEqual({});

      $httpBackend.flush();
      expect(ctrl.plant).toEqual(xyzPlantData);
    });

  });

});
