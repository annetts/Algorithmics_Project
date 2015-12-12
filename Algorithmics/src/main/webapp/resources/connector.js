var app = angular.module('projectApp', []);

app.controller('CountryCtrl', function ($scope, $http){
  $http.get('list').success(function(data) {
    $scope.algorithms = data.algorithms;
  });
});