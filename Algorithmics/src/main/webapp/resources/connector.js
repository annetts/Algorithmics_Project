var app = angular.module('projectApp', []);

app.controller('SelectCtrl', function ($scope, $http){
  $http.get('list').success(function(data) {
    $scope.algorithms = data.algorithms;
  });
  
  $scope.reset = function () {
  	
  	var data = {
  		  algor1: $scope.selectedItem_0,
  		  algor2: $scope.selectedItem_1
  	};
  	
  	var transform = function(data){
        return $.param(data);
    }
  	
  	$http.post('start', data, {
  		headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
  		transformRequest: transform
  		})
  		.success(function (data, status) {
  			
  		});
  };
  
});