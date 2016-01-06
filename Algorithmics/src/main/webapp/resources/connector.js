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
  	var timer;
  	$http.post('start', data, {
  		headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
  		transformRequest: transform
  		})
  		.success(function (data, status) {
  			timer = setInterval(update, 1000);
  		})
  		;
  	
  		function update() {
  			$http.get('next').success(function(data1) {
  				for (var key in data1.next[0].board) {
  					buttons[key] = data1.next[0].board[key];
  					clearCanvas();
  					drawBoard();
  					drawButtons();
  				}
  			}).error(function(data, status) {
  				clearTimeout(timer);
  				drawWin("GAME OVER!");
  			});
  		}
  };
  
});