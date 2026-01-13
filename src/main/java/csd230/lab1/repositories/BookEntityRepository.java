package csd230.lab1.repositories;

import csd230.lab1.entities.BookEntity;
import csd230.lab1.pojos.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findById(Long id);
    List<BookEntity> findAllByTitleLike(String title);
    @Query
    List<BookEntity> findAllByPriceLessThanEqual(double price);
    List<Book> findByIsbn(String isbn);
}