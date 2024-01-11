package com.example.librarymanagement.service;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addOneUser(User user) {
        long unixTimestampSeconds = System.currentTimeMillis() / 1000;
        user.setRegistrationTime(unixTimestampSeconds);
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateById(Integer id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            u.setName(user.getName());
            u.setPassword(user.getPassword());
            u.setPhone(user.getPhone());
            userRepository.save(u);
        } else {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
