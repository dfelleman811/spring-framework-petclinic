package org.springframework.samples.petclinic.playground;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@ActiveProfiles("base-test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, PhilodendronConfig.class})
public class PlantDelivererPhilTest {

    @Autowired
    PlantDeliverer plantDeliverer;

    @org.junit.Test
    public void deliver() {
        String plant = plantDeliverer.deliver();
        assertEquals("I'm a philodendron!", plant);

    }
}
