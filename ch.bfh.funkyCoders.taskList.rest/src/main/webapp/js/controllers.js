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
.controller('ProjectEditController', function($scope, $state, $stateParams, Project, $window) {
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
.controller('OwnerListController', function($scope, $state, popupService, $window, Person) {
    $scope.owners = Person.query();
    $scope.deletePerson = function(owner) {
        if (popupService.showPopup('Really delete this?')) {
            owner.$delete(function() {
                $state.go($state.current, {}, {reload: true});
            });
        }
    };
})
.controller('OwnerCreateController', function($scope, $state, $stateParams, Person) {
    $scope.owner = new Person();
    $scope.addPerson = function() {
        $scope.owner.$save(function() {
            $state.go('owners');
        });
    };
})
.controller('OwnerEditController', function($scope, $state, $stateParams, Person) {
    $scope.updatePerson = function() {
        $scope.owner.$update(function() {
            $state.go('owners');
        });
    };
    $scope.loadPerson = function() {
        $scope.owner = Person.get({ id: $stateParams.id });
    };
    $scope.loadPerson();
});