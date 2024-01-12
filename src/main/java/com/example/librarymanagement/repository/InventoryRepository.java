package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
