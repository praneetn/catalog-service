package com.we.us.catalogservice.repository;

import com.we.us.catalogservice.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    public Book save(Book book);

    public void deleteByIsbn(String isbn);

    public Book update(String isbn, Book book);

    public Optional<Book> findByIsbn(String isbn);

    public List<Book> findAll();
}
