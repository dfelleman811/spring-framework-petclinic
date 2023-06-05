package org.springframework.samples.petclinic.playground;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class PhilodendronPlantProducer implements PlantProducer {

    @Override
    public String getPlant() {
        return "I'm a philodendron!";
    }
}
