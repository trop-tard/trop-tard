var router = angular.module('trop-tard.router', []);

router
    .config(['$urlRouterProvider',
        function($urlRouterProvider) {

            $urlRouterProvider.otherwise("/login");

        }]);

router
    .config(['$stateProvider',
        function($stateProvider) {

            $stateProvider

                .state('login', {
                    url :'/login',
                    views :  {
                        '': {
                            templateUrl: 'partials/login.html',
                            controller: 'trop-tard.controller.login',
                        },
                    },
                })

                .state('home', {
                    url :'/',
                    views :  {
                        '': {
                            controller: 'trop-tard.controller.home',
                            templateUrl: 'partials/home.html',
                        },
                    },
                })
                
                .state('preferences', {
                    url :'/preferences',
                    views :  {
                        '': {
                            controller: 'trop-tard.controller.preferences',
                            templateUrl: 'partials/preferences.html',
                        },
                    },
                })
                
                .state('bonus', {
                    url :'/bonus',
                    views :  {
                        '': {
                            controller: 'trop-tard.controller.bonus',
                            templateUrl: 'partials/bonus.html',
                        },
                    },
                })
    }])