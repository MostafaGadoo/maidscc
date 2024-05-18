package com.example.maidscc.service;

import com.example.maidscc.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(), bookService.getAllBooks());
    }

}