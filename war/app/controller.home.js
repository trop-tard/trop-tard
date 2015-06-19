var controller = angular.module('trop-tard.controller.home', []);

controller.controller('trop-tard.controller.home', ['$scope', 'GApi',
    function homeCtl($scope, GApi) {
		$scope.moment={};
		$scope.avenir ={};

        GApi.executeAuth('userendpoint', 'listUser').then(function(resp) {
                $scope.moments = resp.moment;
                $scope.avenirs = resp.avenir;
                console.log(resp.items);
            });
        
        /*
         $scope.score ={};

        GApi.executeAuth('userendpoint', 'getUser',{id : $scope.user.id}).then(function(resp) {
                $scope.scores = resp;
                console.log(resp.items);
            });
         */

    }
]);