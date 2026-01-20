package csd230.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity @DiscriminatorValue("TICKET")
public class TicketEntity extends ProductEntity {

    private String description;

    public TicketEntity() {}

    public TicketEntity(String d, double p) { this.description = d; setPrice(p); }

    @Override
    public void sellItem() { System.out.println("Selling Ticket: " + description  ); }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) { this.description = d; }


    @Override
    public String toString() {
        return "Ticket{desc='" + description + "', ="  + "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
