'use strict';

angular.module('tasklist', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/project/', { templateUrl: 'projects.tpl.html' })
            .when('/project/:id', {  templateUrl: 'tasks.tpl.html' })
            .otherwise({ redirectTo: '/project/'});
    })
;