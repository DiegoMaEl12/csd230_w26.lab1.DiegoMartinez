package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DiscMagEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        DiscMagEntity discMag = new DiscMagEntity();
        assertNotNull(discMag);
    }

    @Test
    void parameterizedConstructor_shouldSetHasDiscCorrectly() {
        DiscMagEntity discMag = new DiscMagEntity(
                "Tech Monthly",
                9.99,
                10,
                5,
                LocalDateTime.now(),
                true
        );

        assertTrue(discMag.isHasDisc());
    }

    @Test
    void equals_shouldReturnTrue_whenHasDiscIsSame() {
        DiscMagEntity mag1 = new DiscMagEntity(
                "Magazine A",
                5.0,
                3,
                1,
                LocalDateTime.now(),
                true
        );

        DiscMagEntity mag2 = new DiscMagEntity(
                "Magazine B",
                7.0,
                6,
                2,
                LocalDateTime.now(),
                true
        );

        assertEquals(mag1, mag2);
        assertEquals(mag1.hashCode(), mag2.hashCode());
    }
}
