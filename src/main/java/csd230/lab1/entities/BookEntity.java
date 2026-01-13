package csd230.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity @DiscriminatorValue("BOOK")
public class BookEntity extends PublicationEntity {

    private String author;
    private String isbn;

    public BookEntity() {}

    public BookEntity(String t, double p, int c, String a, String i) {
        super(t, p, c); this.author = a; this.isbn = i;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        this.author = a;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                "isbn='" + isbn + '\'' +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(author);
    }
}
