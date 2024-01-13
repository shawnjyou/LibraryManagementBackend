package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.phone = :phone")
    List<User> findByPhone(String phone);
}
