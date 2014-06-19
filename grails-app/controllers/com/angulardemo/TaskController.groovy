package com.angulardemo

class TaskController {
    def index() {
        [taskList: Task.list()]
    }
}
