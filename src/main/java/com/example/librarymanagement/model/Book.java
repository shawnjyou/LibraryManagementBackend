package com.example.librarymanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "isbn", nullable = false)
    private long isbn;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "introduction")
    private String introduction;

    public Book() {
    }

    public Book(long isbn, String author, String name, String introduction) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.introduction = introduction;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
