package com.we.us.catalogservice.repository;

import com.we.us.catalogservice.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return findByIsbn(book.getIsbn()).get();
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);

    }

    @Override
    public Book update(String isbn, Book book) {
        Optional<Book> optionalBook= findByIsbn(isbn);
        if(optionalBook.isPresent())
        {
            books.put(isbn, book);
        }
        return book;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        Book book = books.get(isbn);
        return book == null ? Optional.empty() : Optional.of(book);
    }

    @Override
    public List<Book> findAll() {
        return books.values().stream().collect(Collectors.toList());
    }
}
