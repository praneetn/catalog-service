package com.we.us.catalogservice.service;

import com.we.us.catalogservice.domain.Book;
import com.we.us.catalogservice.exception.BookAlreadyExistsException;
import com.we.us.catalogservice.exception.BookNotFoundException;
import com.we.us.catalogservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        Book savedBook=bookRepository.save(book);
        System.out.println("Saved Book " + savedBook);
        return savedBook;
    }

    @Override
    public void removeBook(String isbn) {
        if (!bookRepository.findByIsbn(isbn).isPresent()) {
            throw new BookNotFoundException(isbn);
        }
        bookRepository.deleteByIsbn(isbn);
    }

    @Override
    public Book editBookDetails(String isbn, Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        return bookRepository.update(isbn,book);
    }

    @Override
    public Book getBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
