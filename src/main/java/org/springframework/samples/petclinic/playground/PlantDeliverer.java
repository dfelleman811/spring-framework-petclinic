package org.springframework.samples.petclinic.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantDeliverer {

    private final PlantProducer plantProducer;

    @Autowired
    public PlantDeliverer(PlantProducer plantProducer) {
        this.plantProducer = plantProducer;
    }

    public String deliver() {
        return this.plantProducer.getPlant();
    }
}
