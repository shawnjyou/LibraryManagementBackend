package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Inventory;
import com.example.librarymanagement.model.InventoryStatus;
import com.example.librarymanagement.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addOneInventory(Inventory inventory) {
        Long unixTimestampSeconds = System.currentTimeMillis() / 1000;
        inventory.setStoreTime(unixTimestampSeconds);
        return inventoryRepository.save(inventory);
    }

    public void deleteById(Integer id) {
        inventoryRepository.deleteById(id);
    }

    public void updateInventoryStatus(Integer id, InventoryStatus status) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            inventory.setStatus(status);
            inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("Inventory with id " + id + " not found");
        }
    }

    public Iterable<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}
