package com.angulardemo

import grails.converters.JSON

class Task {
    String name
    Boolean isDone = false
    Date dateCreated

    static constraints = {
    }

    JSON toJSON() {
        return JSON.build {
            id(id)
            name(name)
            isDone(isDone)
            dateCreated(dateCreated)
        }
    }
}
