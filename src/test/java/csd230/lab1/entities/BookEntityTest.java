package csd230.lab1.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookEntityTest {

    @Test
    void defaultConstructor_shouldCreateObject() {
        BookEntity book = new BookEntity();
        assertNotNull(book);
    }


    @Test
    void setAuthor_shouldUpdateAuthor() {
        BookEntity book = new BookEntity();
        book.setAuthor("J. K. Rowling");

        assertEquals("J. K. Rowling", book.getAuthor());
    }

    @Test
    void equals_shouldReturnTrue_forSameAuthor() {
        BookEntity book1 = new BookEntity(
                "Book A",
                10.0,
                1,
                "George Orwell",
                "111"
        );

        BookEntity book2 = new BookEntity(
                "Book B",
                20.0,
                3,
                "George Orwell",
                "222"
        );

        assertEquals(book1, book2);
    }

    @Test
    void equals_shouldReturnFalse_forDifferentAuthor() {
        BookEntity book1 = new BookEntity(
                "1984",
                15.0,
                2,
                "George Orwell",
                "111"
        );

        BookEntity book2 = new BookEntity(
                "Brave New World",
                15.0,
                2,
                "Aldous Huxley",
                "222"
        );

        assertNotEquals(book1, book2);
    }

    @Test
    void equals_shouldReturnFalse_forNull() {
        BookEntity book = new BookEntity();
        assertNotEquals(book, null);
    }

    @Test
    void equals_shouldReturnFalse_forDifferentClass() {
        BookEntity book = new BookEntity();
        String notABook = "Not a book";

        assertNotEquals(book, notABook);
    }

    @Test
    void hashCode_shouldBeSame_forEqualObjects() {
        BookEntity book1 = new BookEntity(
                "Book A",
                10.0,
                1,
                "Isaac Asimov",
                "111"
        );

        BookEntity book2 = new BookEntity(
                "Book B",
                20.0,
                2,
                "Isaac Asimov",
                "222"
        );

        assertEquals(book1.hashCode(), book2.hashCode());
    }

}
