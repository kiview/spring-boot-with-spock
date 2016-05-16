package com.groovycoder.spockboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * TODO: add documentation
 */
@Entity
public class HistoricTemperatureData {

    @Id
    @GeneratedValue
    private Long id;

    private int temperature;

    private Timestamp created;

    public HistoricTemperatureData(int temperature, Timestamp created) {
        this.temperature = temperature;
        this.created = created;
    }

    protected HistoricTemperatureData() {}

    public int getTemperature() {
        return temperature;
    }

    public Timestamp getCreated() {
        return created;
    }
}
