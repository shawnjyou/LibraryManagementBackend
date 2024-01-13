package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> addOneUser(@RequestBody User user) {
        List<User> userList = userService.findByPhone(user.getPhone());
        if (userList.isEmpty()) {
            User addedUser = userService.addOneUser(user);
            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Integer id, @RequestBody User updateUser) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.updateById(id, updateUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> findAllUsers() {
        Iterable<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
