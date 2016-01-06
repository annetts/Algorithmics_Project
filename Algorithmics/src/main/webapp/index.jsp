<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Algorithmics</title>
	
	<link rel="stylesheet" href="resources/bootstrap.min.css">
	
	<script type="text/javascript" src="resources/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="resources/angular.min.js"></script>
	
</head>

<body  ng-app="projectApp">
	
	<div class="container">
		<div class="row">
			<div ng-controller="SelectCtrl" class="col-md-3">
				<div class = "well">
					First algorithm:
					<select ng-model="selectedItem_0">
						<option ng-repeat="algorithm in algorithms" value="{{algorithm.name}}">{{algorithm.name}}</option>
					</select>
					<br>
					Second algorithm:
					<select ng-model="selectedItem_1">
						<option ng-repeat="algorithm in algorithms" value="{{algorithm.name}}">{{algorithm.name}}</option>
					</select>
					<br>
					<input type="text" ng-model="speed">
					<br>
					<button class="btn btn-default" ng-click="reset()">START</button>
				</div>
			</div>

			<div class="col-md-9">
				<canvas id="mainCanvas" width="560" height="560" style="border:2px solid #d3d3d3;">
				Your browser does not support canvas
				</canvas>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="resources/logic.js"></script>
	<script type="text/javascript" src="resources/connector.js"></script>
</body>
</html>