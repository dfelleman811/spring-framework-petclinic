package org.springframework.samples.petclinic.playground.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.playground.PlantDeliverer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("component-scan")
@SpringJUnitConfig(classes = { PlantDelivererComponentScansTest.TestConfig.class})
class PlantDelivererComponentScansTest {

    @Profile("component-scan")
    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.playground")
    static class TestConfig {
        // this is a handy way to bring in components from multiple classes for your tests
        // or if you had very specific component requirements for your tests
    }

    @Autowired
    PlantDeliverer plantDeliverer;

    @Test
    void deliver() {
        String plant = plantDeliverer.deliver();

        assertEquals("I'm a philodendron!", plant);
    }
}
