package com.we.us.catalogservice.service;

import com.we.us.catalogservice.domain.Book;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);
    public void removeBook(String isbn);
    public Book editBookDetails(String isbn,Book book);
    public Book getBookDetails(String isbn);
    public List<Book> getBookList();
}
