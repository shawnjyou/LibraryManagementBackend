package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.BorrowRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BorrowRecordRepository extends CrudRepository<BorrowRecord, Integer> {
}
