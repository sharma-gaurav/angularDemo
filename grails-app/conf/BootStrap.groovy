import com.angulardemo.Task
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(new org.codehaus.groovy.grails.web.converters.marshaller.json.InstanceMethodBasedMarshaller());
        new Task(name:"Development", isDone: true).save(failOnError: true)
        new Task(name:"Testing", isDone: false).save(failOnError: true)
    }
    def destroy = {
    }
}
