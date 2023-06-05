package org.springframework.samples.petclinic.playground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("base-test")
@Configuration
public class BaseConfig {

    @Bean
    public PlantDeliverer plantDeliverer(PlantProducer plantProducer) {
        return new PlantDeliverer(plantProducer);
    }
}
