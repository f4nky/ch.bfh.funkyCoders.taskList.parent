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
    }).state('tag', {
        url: '/tags',
        templateUrl: 'view/tag_all.html',
        controller: 'TagListController'
    }).state('newTag', {
        url: '/tag/new',
        templateUrl: 'view/tag_new.html',
        controller: 'TagCreateController'
    }).state('editTag', {
        url: '/tag/:id/edit',
        templateUrl: 'view/tag_edit.html',
        controller: 'TagEditController'
    });

}).run(function($state) {
    $state.go('project');
});