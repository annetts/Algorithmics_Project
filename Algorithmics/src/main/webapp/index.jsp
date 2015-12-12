<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Algorithmics</title>
	
	<link rel="stylesheet" href="resources/bootstrap.min.css">
	<script type="text/javascript" src="resources/angular.min.js"></script>
	<script type="text/javascript" src="resources/connector.js"></script>
	
</head>

<body  ng-app="projectApp">
	
	<div class="text-center">
		<div ng-controller="CountryCtrl" class="row">
			
			<div class="col-sm-6">
				First algorithm:
				<select ng-model="selectedItem_0">
					<option ng-repeat="algorithm in algorithms" value="{{algorithm.name}}">{{algorithm.name}}</option>
				</select>
			</div>
			
			<div class="col-sm-6">
				Second algorithm:
				<select ng-model="selectedItem_1">
					<option ng-repeat="algorithm in algorithms" value="{{algorithm.name}}">{{algorithm.name}}</option>
				</select>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<canvas id="mainCanvas" width="560" height="560" style="border:2px solid #d3d3d3;">
				Your browser does not support canvas
				</canvas>
			</div>
		</div>
	</div>

<script type="text/javascript" src="resources/logic.js"></script>
</body>
</html>