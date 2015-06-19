var app = angular.module('controller.preferences',[]);

app.controller('controller.preferences',
	['$scope', 'GAuth','$state' , 'GApi', function ( $scope, GAuth,$state, GApi ) {
		$scope.preference = {};
		
		GApi.executeAuth('preferenceendpoint', 'listPreference').then( function(resp) {
			$scope.preferences = resp.items;
			console.log(resp);
		});
	  
	}
	]);

