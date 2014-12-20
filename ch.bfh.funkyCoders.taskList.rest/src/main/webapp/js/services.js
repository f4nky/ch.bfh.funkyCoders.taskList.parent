angular.module('tasklist.services', [])
    .factory('Project', function($resource) {
        return $resource('rest/projects/:id', { id: '@id' }, {
            update: {
                method: 'PUT',
                url: 'rest/projects'
            }
        });
    }).factory('Task', function($resource) {
        return $resource('rest/tasks/:id', { id: '@id' }, {
            update: {
                method: 'PUT',
                url: 'rest/tasks'
            }
        });
    }).service('popupService',function($window){
        this.showPopup=function(message){
            return $window.confirm(message);
        }
    })
;