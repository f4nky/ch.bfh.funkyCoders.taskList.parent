angular.module('tasklist.controllers', [])
.controller('SelectController', function($scope) {
    $scope.sortOptions = [
        { id: 'id', name: 'Order by #' },
        { id: 'name', name: 'Order by name' },
        { id: 'description', name: 'Order by desc.' },
        { id: '"end date"', name: 'Order by date' }
    ];
    $scope.sortProjects = [
        { id: 'id', name: 'Order by #' },
        { id: 'name', name: 'Order by name' },
        { id: '"end date"', name: 'Order by date' }
    ];
    $scope.filterOptions = [
        { id: {status:"!DELETED"}, name: 'Show all tasks' },
        { id: {status:"OPEN"}, name: 'Open tasks' },
        { id: {status:"DONE"}, name: 'Completed tasks' }
    ];
}).controller('StatusController',function($state, $scope, Task){
        $scope.setStatus=function(id, status){
        $scope.task = Task.get({ id: id }, function() {
            $scope.task.status = status;
            $scope.task.$update();
        });
    }
})
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
.controller('TaskListController', function($scope, $state, $stateParams, popupService, $window, Project, Task) {
    $scope.project = Project.get({ id: $stateParams.id });
    $scope.deleteTask = function(tid) {
        if (popupService.showPopup('Really delete this?' )) {
            $scope.task = Task.get({ id: tid }, function() {
                $scope.task.status = "DELETED";
                $scope.task.$update(function() {
                    $state.reload();
                });
            });
        }
    };
})
.controller('TaskCreateController', function($scope, $state, $stateParams, Project, Task) {
    $scope.project = Project.get({ id: $stateParams.id });
    $scope.task = new Task();
    $scope.addTask = function() {
        $scope.project.tasks.push($scope.task);
        $scope.project.$update(function() {
            $state.go('task',{id:$stateParams.id});
        });
    };
})
.controller('TaskEditController', function($scope, $state, $stateParams, Project, Task) {
    $scope.project = Project.get({ id: $stateParams.id });
    $scope.updateTask = function() {
        $scope.task.$update(function() {
            $state.go('task',{id:$stateParams.id});
        });
    };
    $scope.loadTask = function() {
        $scope.task = Task.get({ id: $stateParams.tid });
    };
    $scope.loadTask();
})
.controller('TagListController', function($scope, $state, popupService, $window, Tag) {
    $scope.tags = Tag.query();
    $scope.deleteTag = function(tag) {
        if (popupService.showPopup('Really delete this?')) {
            tag.$delete();
        }
    };
})
.controller('TagCreateController', function($scope, $state, $stateParams, Tag) {
    $scope.tag = new Tag();
    $scope.addTag = function() {
        $scope.tag.$save(function() {
            $state.go('tag');
        });
    };
})
.controller('TagEditController', function($scope, $state, $stateParams, Tag) {
    $scope.updateTag = function() {
        $scope.tag.$update(function() {
            $state.go('tag');
        });
    };
    $scope.loadTag = function() {
        $scope.tag = Tag.get({ id: $stateParams.id });
    };
    $scope.loadTag();
})