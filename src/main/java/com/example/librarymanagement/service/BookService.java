package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addOneBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteByIsbn(Long isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public void updateByIsbn(Long isbn, Book book) {
        book.setIsbn(isbn);
        bookRepository.save(book);
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
