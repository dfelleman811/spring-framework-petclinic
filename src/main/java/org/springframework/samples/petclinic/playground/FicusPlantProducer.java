package org.springframework.samples.petclinic.playground;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ficus")
@Primary
@Component
public class FicusPlantProducer implements PlantProducer {
    @Override
    public String getPlant() {
        return "I'm a ficus!";
    }
}
