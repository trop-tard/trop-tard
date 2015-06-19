var app = angular.module('trop-tard', [

    'ui.router',
    'angular-google-gapi',

    'trop-tard.router',
    'trop-tard.controller',

]);

app.run(['GAuth', 'GApi', '$state', '$rootScope', '$window',
    function(GAuth, GApi, $state, $rootScope, $window) {

        var CLIENT = '35153983746-qfc2aiofclbl9id96m3qoqq6ibesqc49.apps.googleusercontent.com';
        var BASE;
        if($window.location.hostname == 'localhost') {
            BASE = '//localhost:8080/_ah/api';
        } else {
            BASE = 'https://trop-tard.appspot.com/_ah/api';
        }

        GApi.load('evenementendpoint', 'v1', BASE);
        GApi.load('userendpoint', 'v1', BASE);
        GApi.load('preferenceendpoint', 'v1', BASE);
        GApi.load('calendar', 'v3');
        GAuth.setClient(CLIENT);
        GAuth.setScope('https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/calendar.readonly');
        GAuth.checkAuth().then(
            function () {
                if($state.includes('login'))
                    $state.go('home');
            },
            function() {
                $state.go('login');
            }
        );

        $rootScope.logout = function() {
            GAuth.logout().then(
            function () {
                $state.go('login');
            });
        };
    }
]);