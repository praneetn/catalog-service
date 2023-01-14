package com.we.us.catalogservice.service;

import com.we.us.catalogservice.domain.Book;
import com.we.us.catalogservice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testAddBook() {
        Book book = new Book("123", "Hello World", "Praneet", 9.90);
        //Mockito.when(bookRepository.findByIsbn("123")).thenReturn(Optional.of(book));
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Book response = bookService.addBook(book);
        assertEquals(book.getIsbn(),response.getIsbn());
    }

}