package com.groovycoder.spockboot;

import org.springframework.stereotype.Service;

/**
 * Monitoring service for monitoring the hollandaise temperature.
 */
@Service
public class HollandaiseTemperatureMonitor {

    /** Maximum hollandaise cooking temperature in degree celsius */
    private static final int HOLLANDAISE_MAX_TEMPERATURE_THRESHOLD = 80;

    /** Minimum hollandaise cooking temperature in degree celsius */
    private static final int HOLLANDAISE_MIN_TEMPERATURE_THRESHOLD = 45;

    private final Thermometer thermometer;

    public HollandaiseTemperatureMonitor(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    boolean isTemperatureOk() {
        int temperature = thermometer.currentTemperature();

        boolean belowMinimumThreshold = temperature < HOLLANDAISE_MIN_TEMPERATURE_THRESHOLD;
        boolean aboveMaximumThreshold = temperature > HOLLANDAISE_MAX_TEMPERATURE_THRESHOLD;
        boolean outOfLimits = belowMinimumThreshold || aboveMaximumThreshold;

        return !outOfLimits;
    }

}
