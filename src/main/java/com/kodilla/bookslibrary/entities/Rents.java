package com.kodilla.bookslibrary.entities;

import com.sun.istack.NotNull;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.security.PublicKey;
import java.time.LocalDate;

@Entity
@Table(name = "RENTS")
public class Rents {

    private int id;
    private int customerId;
    private int bookShelfId;
    private LocalDate rentDate;
    private LocalDate returnDate;

    private Customers customers;
//    private BookShelf bookShelf;

    public Rents(int customerid, int bookid, LocalDate rentDate, LocalDate returnDate) {
        this.customerId = customerid;
        this.bookShelfId = bookid;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rents() {}

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "CUSTOMER_ID")
    public int getCustomerid() {
        return customerId;
    }

    private void setCustomerid(int customerid) {
        this.customerId = customerid;
    }

    @NotNull
    @Column(name = "BOOKSHELF_ID")
    public int getBookShelfId() {
        return bookShelfId;
    }

    private void setBookShelfId(int bookShelfId) {
        this.bookShelfId = bookShelfId;
    }

    @Column(name = "RENT_DATE")
    public LocalDate getRentDate() {
        return rentDate;
    }

    private void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    @Column(name = "RETURN_DATE")
    public LocalDate getReturnDate() {
        return returnDate;
    }

    private void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

//    @Override
//    public String toString() {
//        return "Customer " +
//                customers.getFirstname() + " " + customers.getLastname() +
//                "rented book: " + bookShelf.getBooks().getName();
//    }
}
