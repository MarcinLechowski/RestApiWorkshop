package com.Kaer.BookRestApi.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping
    public List<Book> getBook() {
        return mockBookService.getBook();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        mockBookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(
            @PathVariable("bookId") Long bookId){
            mockBookService.deleteBook(bookId);

    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title){
        mockBookService.updateBook(bookId, author, title);


    }

}
