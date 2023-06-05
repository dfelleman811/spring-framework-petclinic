package org.springframework.samples.petclinic.playground.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.playground.PhilodendronPlantProducer;
import org.springframework.samples.petclinic.playground.PlantDeliverer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("inner-class")
@SpringJUnitConfig(classes = {PlantDelivererInnerClassTest.TestConfig.class})
class PlantDelivererInnerClassTest {

    // inner class config - good way to make small tweaks to config for tests - something specific or if you're overriding something
    @Profile("inner-class")
    @Configuration
    static class TestConfig {
        @Bean
        PlantDeliverer plantDeliverer() {
            return new PlantDeliverer(new PhilodendronPlantProducer());
        }
    }

    @Autowired
    PlantDeliverer plantDeliverer;

    @Test
    void deliver() {
        String plant = plantDeliverer.deliver();
        assertEquals("I'm a philodendron!", plant);
    }
}
