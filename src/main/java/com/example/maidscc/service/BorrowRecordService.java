package com.example.maidscc.service;

import com.example.maidscc.Repository.BookRepository;
import com.example.maidscc.Repository.BorrowingRecordsRepository;
import com.example.maidscc.Repository.PatronRepository;
import com.example.maidscc.entity.BookEntity;
import com.example.maidscc.entity.BorrowingRecordEntity;
import com.example.maidscc.entity.PatronEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowingRecordsRepository borrowingRecordRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public Optional<BorrowingRecordEntity> borrowBook(Long bookId, Long patronId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);
        Optional<PatronEntity> patron = patronRepository.findById(patronId);

        if (book.isPresent() && patron.isPresent()) {
            BorrowingRecordEntity record = new BorrowingRecordEntity();
            record.setBook(book.get());
            record.setPatron(patron.get());
            record.setBorrowingDate(LocalDate.now());
            borrowingRecordRepository.save(record);
            return Optional.of(record);
        } else {
            return Optional.empty();
        }
    }
}
