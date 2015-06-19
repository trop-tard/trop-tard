var controller = angular.module('trop-tard.controller.login', []);

controller.controller('trop-tard.controller.login', ['$scope', 'GAuth', 'GData', '$state',
    function clientList($scope, GAuth, GData, $state) {
    	if(GData.isLogin()){
    		$state.go('home');
    	}

        $scope.doLogin = function() {
            GAuth.login().then(function(){
            	$state.go('home');
            });
        };
    }
])