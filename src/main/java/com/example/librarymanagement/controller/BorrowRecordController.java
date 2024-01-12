package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.BorrowRecord;
import com.example.librarymanagement.service.BorrowRecordService;
import com.example.librarymanagement.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.librarymanagement.model.InventoryStatus.ON_LOAN;
import static com.example.librarymanagement.model.InventoryStatus.PROCESSING;

@RestController
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    private final InventoryService inventoryService;

    public BorrowRecordController(BorrowRecordService borrowRecordService, InventoryService inventoryService) {
        this.borrowRecordService = borrowRecordService;
        this.inventoryService = inventoryService;
    }


    @PostMapping("/borrow_record")
    public ResponseEntity<BorrowRecord> addOneBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        BorrowRecord addedBorrowRecord = borrowRecordService.addOneBorrowRecord(borrowRecord);
        inventoryService.updateInventoryStatus(borrowRecord.getInventory().getId(), ON_LOAN);
        return new ResponseEntity<>(addedBorrowRecord, HttpStatus.CREATED);
    }

    @DeleteMapping("/borrow_record/{id}")
    public ResponseEntity<Void> deleteByIsbn(@PathVariable Integer id) {
        Optional<BorrowRecord> borrowRecord = borrowRecordService.findById(id);
        if (borrowRecord.isPresent()) {
            borrowRecordService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/borrow_record/{id}/return")
    public ResponseEntity<String> updateReturnDateAndStatus(@PathVariable Integer id) {
        Optional<BorrowRecord> borrowRecord = borrowRecordService.findById(id);
        if (borrowRecord.isPresent()) {
            borrowRecordService.updateReturnDateAndStatus(id);
            inventoryService.updateInventoryStatus(borrowRecord.get().getInventory().getId(), PROCESSING);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/borrow_records")
    public ResponseEntity<Iterable<BorrowRecord>> findAllBorrowRecords() {
        Iterable<BorrowRecord> borrowRecords = borrowRecordService.findAllBorrowRecords();
        return new ResponseEntity<>(borrowRecords, HttpStatus.OK);
    }

    @GetMapping("/borrow_record/{id}")
    public ResponseEntity<Optional<BorrowRecord>> findById(@PathVariable Integer id) {
        Optional<BorrowRecord> borrowRecord = borrowRecordService.findById(id);
        if (borrowRecord.isPresent()) {
            return new ResponseEntity<>(borrowRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
