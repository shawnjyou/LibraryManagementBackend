package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Optional<Book> findByIsbn(Long isbn);

    @Modifying
    @Query("DELETE FROM Book b WHERE b.isbn = :isbn")
    void deleteByIsbn(Long isbn);
}
