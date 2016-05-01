package com.groovycoder.spockboot

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit tests for {@link HollandaiseTemperatureMonitor}.
 */
class HollandaiseTemperatureMonitorSpec extends Specification {

    @Unroll
    def "returns #temperatureOk for temperature #givenTemperature"() {
        given: "a stub thermometer returning given givenTemperature"
        Thermometer thermometer = Stub(Thermometer)
        thermometer.currentTemperature() >> givenTemperature

        and: "a monitor with the stubbed thermometer"
        HollandaiseTemperatureMonitor watchman = new HollandaiseTemperatureMonitor(thermometer)

        expect:
        watchman.isTemperatureOk() == temperatureOk

        where:
        givenTemperature || temperatureOk
        0                || false
        100              || false
        80               || true
        45               || true
        60               || true
        -10              || false
    }

}
