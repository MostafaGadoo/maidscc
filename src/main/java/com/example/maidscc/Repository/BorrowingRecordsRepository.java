package com.example.maidscc.Repository;

import com.example.maidscc.entity.BorrowingRecordEntity;
import com.example.maidscc.entity.PatronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordsRepository extends JpaRepository<BorrowingRecordEntity, Long> {
}
