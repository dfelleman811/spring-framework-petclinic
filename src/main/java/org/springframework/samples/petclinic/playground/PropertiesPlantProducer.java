package org.springframework.samples.petclinic.playground;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("external-properties")
@Primary
public class PropertiesPlantProducer implements PlantProducer{

    private String plant;

    @Value("${plant}")
    public void setPlant(String plant) {
        this.plant = plant;
    }
    @Override
    public String getPlant() {
        return this.plant;
    }
}
