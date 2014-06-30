var taskApp = angular.module('taskApp', []);
taskApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {redirectTo: '/todo'})
        .when('/todo', {templateUrl: '/'})
});


function TaskController($scope, $http) {
    $scope.newTask = {};

    var successCallback = function (data) {
        $scope.tasks = data;
    };
    var failureCallback = function () {
        alert("Something bad happened!");
    };

    $http.post('/task/list', {}).success(successCallback).error(failureCallback);

    $scope.createTask = function () {
        $http.post('/task/create', $scope.newTask).success(function (data) {
            $scope.tasks.push($scope.newTask);
            $scope.newTask = {};
        });
    };

    $scope.toggleDone = function(todo, idx) {
        $http.post('/task/toggleDone', {id: todo.id, isDone: !todo.isDone}).success(function (data) {
            $scope.tasks[idx] = data;
            console.log($scope.tasks[idx])
        });
    }
};