package com.groovycoder.spockboot;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository for {@link HistoricTemperatureData} entities.
 */
public interface HistoricTemperatureDataRepository extends CrudRepository<HistoricTemperatureData, Long> {
}
