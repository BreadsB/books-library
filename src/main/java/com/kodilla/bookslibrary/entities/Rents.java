package com.kodilla.bookslibrary.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RENTS")
public class Rents {

    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;

    private Customers customers;
    private BookPosition bookPosition;

    public Rents(LocalDate rentDate, LocalDate returnDate) {
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

    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOKPOSITION_ID")
    public BookPosition getBookPosition() {
        return bookPosition;
    }

    public void setBookPosition(BookPosition bookPosition) {
        this.bookPosition = bookPosition;
    }
}
