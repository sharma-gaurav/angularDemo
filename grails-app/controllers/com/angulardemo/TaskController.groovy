package com.angulardemo

import grails.converters.JSON

class TaskController {
    def index() { }

    def list() {
        render Task.list() as JSON
    }

    def create(Task task) {
        println task.dump()
        task.save(failOnError: true, flush:true)
        render task as JSON
    }

    def toggleDone(Task task) {
        println task.dump()
        task.save(failOnError: true, flush: true)
        render task as JSON
    }
}
