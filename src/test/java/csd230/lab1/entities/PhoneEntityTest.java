package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        PhoneEntity phone = new PhoneEntity();
        assertNotNull(phone);
    }

    @Test
    void parameterizedConstructor_shouldSetFieldsCorrectly() {
        PhoneEntity phone = new PhoneEntity("PH-001", 10, "Rogers");

        assertEquals("PH-001", phone.getSerialNumber());
        assertEquals(10, phone.getQuantity());
        assertEquals("Rogers", phone.getCarrier());
    }

    @Test
    void setCarrier_shouldUpdateCarrier() {
        PhoneEntity phone = new PhoneEntity();
        phone.setCarrier("Bell");

        assertEquals("Bell", phone.getCarrier());
    }
}
