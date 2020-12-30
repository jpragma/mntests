package com.jpragma

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MyServiceImplTest extends Specification {
    @Inject
    MyService myService

    @Inject
    Greeter mockGreeter

    @MockBean(GreeterImpl)
    Greeter mockGreeter() {
        println("*** creating mock")
        Mock(Greeter)
    }

    def "greeter is invoked"() {
        given:
        String name = "World"
        when:
        def greeting = myService.greet(name)
        then:
        1 * mockGreeter.greetInEnglish(_) >> "Hey there"
        greeting == "Hey there"
    }

}
