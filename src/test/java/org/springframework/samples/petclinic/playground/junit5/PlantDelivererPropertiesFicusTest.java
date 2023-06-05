package org.springframework.samples.petclinic.playground.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.playground.PlantDeliverer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("classpath:ficus.properties")
@ActiveProfiles("external-properties")
@SpringJUnitConfig(classes = PlantDelivererPropertiesFicusTest.TestConfig.class)
public class PlantDelivererPropertiesFicusTest {
    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.playground")
    static class TestConfig {}

    @Autowired
    PlantDeliverer plantDeliverer;

    @Test
    public void deliver() {
        String plant = plantDeliverer.deliver();

        assertEquals("FICUS", plant);
    }
}
