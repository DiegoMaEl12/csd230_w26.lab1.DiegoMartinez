package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        TicketEntity ticket = new TicketEntity();
        assertNotNull(ticket);
    }

    @Test
    void parameterizedConstructor_shouldSetDescriptionAndPrice() {
        TicketEntity ticket = new TicketEntity("Concert Ticket", 79.99);

        assertEquals("Concert Ticket", ticket.getDescription());
        assertEquals(79.99, ticket.getPrice());
    }

    @Test
    void equals_shouldReturnTrue_forSameDescriptionAndPrice() {
        TicketEntity t1 = new TicketEntity("Movie Ticket", 18.99);
        TicketEntity t2 = new TicketEntity("Movie Ticket", 18.99);

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
    }
}
