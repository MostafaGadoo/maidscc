package com.example.maidscc.Repository;

import com.example.maidscc.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAll() {
        List<BookEntity> books = bookRepository.findAll();
        assertNotNull(books);
        assertEquals(0, books.size());
    }

}