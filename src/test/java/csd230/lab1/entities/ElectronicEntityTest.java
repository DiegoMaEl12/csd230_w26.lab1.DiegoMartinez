package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectronicEntityTest {

    // Minimal concrete subclass ONLY for testing
    static class TestElectronicEntity extends ElectronicEntity {
        public TestElectronicEntity(String serialNumber, int quantity) {
            super(serialNumber, quantity);
        }
    }

    @Test
    void constructor_shouldSetSerialNumberAndQuantity() {
        ElectronicEntity electronic = new TestElectronicEntity("SN-123", 5);

        assertEquals("SN-123", electronic.getSerialNumber());
        assertEquals(5, electronic.getQuantity());
    }

    @Test
    void sellItem_shouldDecreaseQuantityWhenInStock() {
        ElectronicEntity electronic = new TestElectronicEntity("SN-456", 2);

        electronic.sellItem();

        assertEquals(1, electronic.getQuantity());
    }

    @Test
    void sellItem_shouldNotDecreaseQuantityWhenOutOfStock() {
        ElectronicEntity electronic = new TestElectronicEntity("SN-789", 0);

        electronic.sellItem();

        assertEquals(0, electronic.getQuantity());
    }
}
