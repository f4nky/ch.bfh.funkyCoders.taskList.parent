angular.module('tasklist.controllers', [])
.controller('ProjectsController', function($scope, Project) {
    $scope.projects = Project.query();
})
.controller('ProjectListController', function($scope, $state, popupService, $window, Project) {
    $scope.projects = Project.query();
    $scope.deleteProject = function(project) {
        if (popupService.showPopup('Really delete this?')) {
            project.$delete(function() {
                $window.location.href = '';
            });
        }
    };
})
.controller('ProjectCreateController', function($scope, $state, $stateParams, Project) {
    $scope.project = new Project();
    $scope.addProject = function() {
        $scope.project.$save(function() {
            $state.go('project');
        });
    };
})
.controller('ProjectEditController', function($scope, $state, $stateParams, Project) {
    $scope.updateProject = function() {
        $scope.project.$update(function() {
            $state.go('project');
        });
    };
    $scope.loadProject = function() {
        $scope.project = Project.get({ id: $stateParams.id });
    };
    $scope.loadProject();
})
.controller('TaskListController', function($scope, $state, $stateParams, popupService, $window, Task, Project) {
    $scope.tasks = Task.query();
    $scope.project = Project.get({ id: $stateParams.id });
    $scope.deleteTask = function(task) {
        if (popupService.showPopup('Really delete this?')) {
            task.$delete(function() {
                $window.location.href = '';
            });
        }
    };
})
.controller('TaskCreateController', function($scope, $state, $stateParams, Task) {
    $scope.task = new Task();
    $scope.addTask = function() {
        $scope.task.$save(function() {
            $state.go('task');
        });
    };
})
.controller('TaskEditController', function($scope, $state, $stateParams, Task) {
    $scope.updateTask = function() {
        $scope.task.$update(function() {
            $state.go('task');
        });
    };
    $scope.loadTask = function() {
        $scope.task = Task.get({ id: $stateParams.id });
    };
    $scope.loadTask();
});