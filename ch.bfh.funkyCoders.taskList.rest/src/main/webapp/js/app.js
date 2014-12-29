'use strict';

angular.module('tasklist', ['ui.router', 'ngResource', 'tasklist.controllers', 'tasklist.services']);

angular.module('tasklist').config(function($stateProvider) {
    $stateProvider.state('project', {
        url: '/projects',
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
        url: '/project/:id/tasks',
        templateUrl: 'view/task_all.html',
        controller: 'TaskListController'
    }).state('newTask', {
        url: '/project/:id/task/new',
        templateUrl: 'view/task_new.html',
        controller: 'TaskCreateController'
    }).state('editTask', {
        url: '/project/:id/task/:tid/edit',
        templateUrl: 'view/task_edit.html',
        controller: 'TaskEditController'
    }).state('owners', {
        url: '/owners',
        templateUrl: 'view/owner_all.html',
        controller: 'OwnerListController'
    }).state('newOwner', {
        url: '/owner/new',
        templateUrl: 'view/owner_new.html',
        controller: 'OwnerCreateController'
    }).state('editOwner', {
        url: '/owner/:id/edit',
        templateUrl: 'view/owner_edit.html',
        controller: 'OwnerEditController'
    })
}).run(function($state) {
    $state.go('project');
});