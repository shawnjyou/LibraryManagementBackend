package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Inventory;
import com.example.librarymanagement.request.InventoryStatusUpdateRequest;
import com.example.librarymanagement.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping("/inventory")
    public ResponseEntity<Inventory> addOneInventory(@RequestBody Inventory inventory) {
        Inventory addedInventory = inventoryService.addOneInventory(inventory);
        return new ResponseEntity<>(addedInventory, HttpStatus.CREATED);
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteByIsbn(@PathVariable Integer id) {
        Optional<Inventory> inventory = inventoryService.findById(id);
        if (inventory.isPresent()) {
            inventoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/inventory/{id}/update-status")
    public ResponseEntity<String> updateInventoryStatus(@PathVariable Integer id, @RequestBody InventoryStatusUpdateRequest request) {
        Optional<Inventory> inventory = inventoryService.findById(id);
        if (inventory.isPresent()) {
            inventoryService.updateInventoryStatus(id, request.getStatus());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/inventories")
    public ResponseEntity<Iterable<Inventory>> findAllInventories() {
        Iterable<Inventory> inventories = inventoryService.findAllInventories();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Optional<Inventory>> findById(@PathVariable Integer id) {
        Optional<Inventory> inventory = inventoryService.findById(id);
        if (inventory.isPresent()) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
