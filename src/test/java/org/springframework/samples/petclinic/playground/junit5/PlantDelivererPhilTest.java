package org.springframework.samples.petclinic.playground.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.playground.BaseConfig;
import org.springframework.samples.petclinic.playground.PhilodendronConfig;
import org.springframework.samples.petclinic.playground.PlantDeliverer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("base-test")
@SpringJUnitConfig(classes = {BaseConfig.class, PhilodendronConfig.class})
class PlantDelivererPhilTest {
    @Autowired
    PlantDeliverer plantDeliverer;

    @Test
    void deliver() {
        String plant = plantDeliverer.deliver();

        assertEquals("I'm a philodendron!", plant);
    }
}
