package com.example.librarymanagement.service;

import com.example.librarymanagement.model.BorrowRecord;
import com.example.librarymanagement.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;

    @Autowired
    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public BorrowRecord addOneBorrowRecord(BorrowRecord borrowRecord) {
        Long unixTimestampSeconds = System.currentTimeMillis() / 1000;
        borrowRecord.setBorrowDate(unixTimestampSeconds);
        return borrowRecordRepository.save(borrowRecord);
    }

    public void deleteById(Integer id) {
        borrowRecordRepository.deleteById(id);
    }

    public void updateReturnDateAndStatus(Integer id) {
        Optional<BorrowRecord> optionalBorrowRecord = borrowRecordRepository.findById(id);
        if (optionalBorrowRecord.isPresent()) {
            BorrowRecord borrowRecord = optionalBorrowRecord.get();
            Long unixTimestampSeconds = System.currentTimeMillis() / 1000;
            borrowRecord.setReturnDate(unixTimestampSeconds);
            borrowRecordRepository.save(borrowRecord);
        } else {
            throw new RuntimeException("BorrowRecord with id " + id + " not found");
        }
    }

    public Iterable<BorrowRecord> findAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public Optional<BorrowRecord> findById(Integer id) {
        return borrowRecordRepository.findById(id);
    }
}
