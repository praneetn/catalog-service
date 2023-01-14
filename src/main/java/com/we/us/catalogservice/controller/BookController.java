package com.we.us.catalogservice.controller;

import com.we.us.catalogservice.domain.Book;
import com.we.us.catalogservice.service.BookService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookDetail(@PathVariable String isbn) {
        return new ResponseEntity<>(bookService.getBookDetails(isbn), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid  @RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> removeBook(@PathVariable String isbn) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn,@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.editBookDetails(isbn, book), HttpStatus.OK);
    }
}
