package com.groovycoder.spockboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

/**
 * Context test without explicit configuration annotation.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationSpecWithoutAnnotation extends Specification {

    @Autowired
    WebApplicationContext context

    def "should boot up without errors"() {
        expect: "web application context exists"
        context != null
    }

}