package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        LaptopEntity laptop = new LaptopEntity();
        assertNotNull(laptop);
    }

    @Test
    void setStorageSize_shouldUpdateValue() {
        LaptopEntity laptop = new LaptopEntity();

        laptop.setStorageSize("512GB SSD");

        assertEquals("512GB SSD", laptop.getStorageSize());
    }

    @Test
    void laptop_shouldInheritElectronicFields() {
        LaptopEntity laptop = new LaptopEntity();

        laptop.setSerialNumber("LAP-001");
        laptop.setQuantity(3);

        assertEquals("LAP-001", laptop.getSerialNumber());
        assertEquals(3, laptop.getQuantity());
    }
}
