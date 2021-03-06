angular.module('tasklist.services', [])
    .factory('Project', function($resource) {
        return $resource('rest/projects/:id', { id: '@id' }, {
            update: {
                method: 'PUT',
                url: 'rest/projects'
            }
        });
    }).factory('Task', function($resource) {
        return $resource('rest/tasks/:id', {id: '@id'}, {
            update: {
                method: 'PUT',
                url: 'rest/tasks'
            }
        });
    }).factory('Person', function($resource) {
        return $resource('rest/owners/:id', {id: '@id'}, {
            update: {
                method: 'PUT',
                url: 'rest/owners'
            }
        });
    }).factory('Tag', function ($resource) {
        return $resource('rest/tags/:id', {id: '@id'}, {
            update: {
                method: 'PUT',
                url: 'rest/tags'
            }
        });
    }).service('popupService', function ($window) {
        this.showPopup = function (message) {
            return $window.confirm(message);
        }
    });