package com.Kaer.BookRestApi.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b from Book b WHERE b.title = ?1")
    Optional<Book> findBooksByTitle(String title);

    Optional<Book> findByAuthor(String author);
}
