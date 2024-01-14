package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.phone = :phone")
    List<User> findByPhone(String phone, Pageable pageable);

    default User findFirstByPhone(String phone) {
        List<User> users = findByPhone(phone, PageRequest.of(0, 1));
        return users.isEmpty() ? null : users.get(0);
    }
}
