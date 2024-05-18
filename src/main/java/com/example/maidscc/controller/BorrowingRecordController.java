package com.example.maidscc.controller;

import com.example.maidscc.entity.BorrowingRecordEntity;
import com.example.maidscc.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {

    @Autowired
    private BorrowRecordService borrowingRecordService;

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordEntity> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        Optional<BorrowingRecordEntity> borrowingRecord = borrowingRecordService.borrowBook(bookId, patronId);
        return borrowingRecord.map(record -> ResponseEntity.status(201).body(record))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
