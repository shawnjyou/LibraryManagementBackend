package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addOneBook(@RequestBody Book book) {
        Book addedBook = bookService.addOneBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<Void> deleteByIsbn(@PathVariable Long isbn) {
        Optional<Book> book = bookService.findByIsbn(isbn);
        if (book.isPresent()) {
            bookService.deleteByIsbn(isbn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/book/{isbn}")
    public ResponseEntity<Void> updateByIsbn(@PathVariable Long isbn, @RequestBody Book updateBook) {
        Optional<Book> book = bookService.findByIsbn(isbn);
        if (book.isPresent()) {
            bookService.updateByIsbn(isbn, updateBook);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> findAllBooks() {
        Iterable<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable Long isbn) {
        Optional<Book> book = bookService.findByIsbn(isbn);
        if (book.isPresent()) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
