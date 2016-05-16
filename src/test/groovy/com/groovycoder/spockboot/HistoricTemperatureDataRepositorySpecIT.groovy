package com.groovycoder.spockboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.sql.Timestamp

@ContextConfiguration // not mentioned by docs, but had to include this for Spock to startup the Spring context
@DataJpaTest
class HistoricTemperatureDataRepositorySpecIT extends Specification {

    @Autowired
    HistoricTemperatureDataRepository historicTemperatureDataRepository

    @Autowired
    TestEntityManager testEntityManager

    def "should load all data"() {
        given: "one temperature entry"
        int temperature = 5
        HistoricTemperatureData data = new HistoricTemperatureData(temperature, new Timestamp(System.currentTimeMillis()))
        testEntityManager.persist(data)

        when: "loading data from repository"
        def loadedData = historicTemperatureDataRepository.findAll()

        then: "persisted data is loaded"
        loadedData.first().temperature == temperature
    }

}
