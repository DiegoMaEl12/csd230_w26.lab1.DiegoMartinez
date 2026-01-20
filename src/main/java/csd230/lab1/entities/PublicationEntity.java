package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public abstract class PublicationEntity extends ProductEntity {

    private String title;

    private int copies;

    public PublicationEntity() {}

    public PublicationEntity(String t, double p, int c) { this.title = t; this.setPrice(p);  this.copies = c; }

    @Override
    public void sellItem() {
        if (copies > 0) { copies--; System.out.println("Sold '" + title + "'. Remaining copies: " + copies); }
        else { System.out.println("Cannot sell '" + title + "'. Out of stock."); }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String t) { this.title = t; }


    public int getCopies() { return copies; }

    public void setCopies(int c) { this.copies = c; }

    @Override
    public String toString() {
        return "PublicationEntity{" +
                "title='" + title + '\'' +
                ", copies=" + copies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PublicationEntity that = (PublicationEntity) o;
        return copies == that.copies && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, copies);
    }
}
