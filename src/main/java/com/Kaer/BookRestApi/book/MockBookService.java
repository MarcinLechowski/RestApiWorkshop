package com.Kaer.BookRestApi.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MockBookService {

    public final BookRepository bookRepository;

    public MockBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository
                .findBooksByTitle(book.getTitle());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Title " + book.getTitle() + " is taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.findById(bookId);
        boolean exist = bookRepository.existsById(bookId);
        if (!exist) {
            throw new IllegalStateException("Book with Id: " + bookId + " do not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId,
                           String author,
                           String title) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "Book with title " + bookId + " do not exist"
                ));
        if (author != null && author.length() > 0 &&
                !Objects.equals(book.getAuthor(), author)) {
            Optional<Book> bookOptional = bookRepository
                    .findByAuthor(author);
        }
        if (title != null && title.length() > 0
                && !Objects.equals(book.getTitle(), title)) {
            Optional<Book> studentOptional = bookRepository
                    .findBooksByTitle(title);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            book.setTitle(title);
        }
    }
}