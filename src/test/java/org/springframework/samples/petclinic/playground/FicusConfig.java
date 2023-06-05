package org.springframework.samples.petclinic.playground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("base-test")
@Configuration
public class FicusConfig {

    @Bean
    FicusPlantProducer ficusPlantProducer() {
        return new FicusPlantProducer();
    }
}
