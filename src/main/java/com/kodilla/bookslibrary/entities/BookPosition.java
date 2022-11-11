package com.kodilla.bookslibrary.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOKPOSITION")
public class BookPosition {

    private int id;
    private String status; // Instead of String put here ENUM

    private Books books;

    private Rents rents;

    public BookPosition(String status) {
        this.status = status;
    }

    public BookPosition() {}

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookPosition")
    public Rents getRents() {
        return rents;
    }

    public void setRents(Rents rents) {
        this.rents = rents;
    }
}