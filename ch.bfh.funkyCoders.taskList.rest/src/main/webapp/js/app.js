'use strict';

angular.module('tasklist', ['ui.router', 'ngResource', 'tasklist.controllers', 'tasklist.services']);

angular.module('tasklist').config(function($stateProvider) {
    $stateProvider.state('project', {
        url: '/project',
        templateUrl: 'view/project_all.html',
        controller: 'ProjectListController'
    }).state('newProject', {
        url: '/project/new',
        templateUrl: 'view/project_new.html',
        controller: 'ProjectCreateController'
    }).state('editProject', {
        url: '/project/:id/edit',
        templateUrl: 'view/project_edit.html',
        controller: 'ProjectEditController'
    }).state('task', {
        url: '/project/:id',
        templateUrl: 'view/task_all.html',
        controller: 'TaskListController'
    }).state('newTask', {
        url: '/task/new',
        templateUrl: 'view/task_new.html',
        controller: 'TaskCreateController'
    }).state('editTask', {
        url: '/task/:id/edit',
        templateUrl: 'view/task_edit.html',
        controller: 'TaskEditController'
    });
}).run(function($state) {
    $state.go('project');
});