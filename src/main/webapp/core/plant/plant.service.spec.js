'use strict';

describe('Plant', function() {
  var $httpBackend;
  var Plant;
  var plantsData = [
    {name: 'Plant X'},
    {name: 'Plant Y'},
    {name: 'Plant Z'}
  ];

  // Add a custom equality tester before each test
  beforeEach(function() {
    jasmine.addCustomEqualityTester(angular.equals);
  });

  // Load the module that contains the `Plant` service before each test
  beforeEach(module('core.plant'));

  // Instantiate the service and "train" `$httpBackend` before each test
  beforeEach(inject(function(_$httpBackend_, _Plant_) {
    $httpBackend = _$httpBackend_;
    $httpBackend.expectGET('plants/plants.json').respond(plantsData);

    Plant = _Plant_;
  }));

  // Verify that there are no outstanding expectations or requests after each test
  afterEach(function () {
    $httpBackend.verifyNoOutstandingExpectation();
    $httpBackend.verifyNoOutstandingRequest();
  });

  it('should fetch the plants data from `/plants/plants.json`', function() {
    var plants = Plant.query();

    expect(plants).toEqual([]);

    $httpBackend.flush();
    expect(plants).toEqual(plantsData);
  });

});
