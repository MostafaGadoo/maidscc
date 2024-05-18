package com.example.maidscc.service;

import com.example.maidscc.Repository.BookRepository;
import com.example.maidscc.entity.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("api/Book")
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }


    public ResponseEntity<BookEntity> getBookById(Long id){
        Optional<BookEntity> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Transactional
    public BookEntity updateBook(Long id, BookEntity newBook) {
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity existingBook = optionalBook.get();
            existingBook.setTitle(newBook.getTitle());
            existingBook.setAuthor(newBook.getAuthor());
            existingBook.setPublicationYear(newBook.getPublicationYear());
            existingBook.setIsbn(newBook.getIsbn());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
