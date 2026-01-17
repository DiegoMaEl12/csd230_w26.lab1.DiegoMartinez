package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MagazineEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        MagazineEntity magazine = new MagazineEntity();
        assertNotNull(magazine);
    }

    @Test
    void parameterizedConstructor_shouldSetOrderQtyAndCurrentIssue() {
        LocalDateTime issueDate = LocalDateTime.now();

        MagazineEntity magazine = new MagazineEntity(
                "Science Weekly",
                6.99,
                20,
                50,
                issueDate
        );

        assertEquals(50, magazine.getOrderQty());
        assertEquals(issueDate, magazine.getCurrentIssue());
    }

    @Test
    void equals_shouldReturnTrue_forSameOrderQtyAndIssue() {
        LocalDateTime issueDate = LocalDateTime.now();

        MagazineEntity mag1 = new MagazineEntity(
                "Mag A",
                5.0,
                5,
                10,
                issueDate
        );

        MagazineEntity mag2 = new MagazineEntity(
                "Mag B",
                7.0,
                8,
                10,
                issueDate
        );

        assertEquals(mag1, mag2);
        assertEquals(mag1.hashCode(), mag2.hashCode());
    }
}
