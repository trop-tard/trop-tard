var controller = angular.module('trop-tard.controller.home', []);

controller.controller('trop-tard.controller.home', ['$scope', 'GAuth','$state' , 'GApi', function ( $scope, GAuth,$state, GApi ) {

	$scope.score;
	$scope.moment;
	$scope.avenir;
	GApi.executeAuth('userendpoint', 'listPreference').then( function(resp) {
		$scope.scores = resp.item;
		console.log(resp)
	});
	/*GApi..executeAuth('userendpoint', 'getUser', {id: $scope.user.id}}).then( function(resp) {
		$scope.moments = resp.moment;
		$scope.avenirs = resp.avenir;
		console.log(resp)
	});*/
	

    }
]);
