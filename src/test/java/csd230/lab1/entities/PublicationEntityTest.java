package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicationEntityTest {

    // Minimal concrete subclass for testing abstract PublicationEntity
    static class TestPublicationEntity extends PublicationEntity {
        public TestPublicationEntity(String title, int copies) {
            this.setTitle(title);
            this.setCopies(copies);
        }
    }

    @Test
    void constructorAndGetters_shouldSetTitleAndCopies() {
        PublicationEntity pub = new TestPublicationEntity("Test Book", 5);

        assertEquals("Test Book", pub.getTitle());
        assertEquals(5, pub.getCopies());
    }

    @Test
    void sellItem_shouldDecreaseCopiesWhenInStock() {
        PublicationEntity pub = new TestPublicationEntity("Magazine", 2);

        pub.sellItem();

        assertEquals(1, pub.getCopies());
    }

    @Test
    void equals_shouldReturnTrue_forSameTitleAndCopies() {
        PublicationEntity pub1 = new TestPublicationEntity("Same Title", 3);
        PublicationEntity pub2 = new TestPublicationEntity("Same Title", 3);

        assertEquals(pub1, pub2);
        assertEquals(pub1.hashCode(), pub2.hashCode());
    }
}
