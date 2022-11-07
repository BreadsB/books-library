package com.kodilla.bookslibrary.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    private int id;
    private String firstname;
    private String lastname;
    private LocalDate registerdate;

    public Customers() {}

    public Customers(final String firstname, final String lastname, final LocalDate registerdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.registerdate = registerdate;
    }

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

    @Column(name = "FIRSTNAME")
    @NotNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "LASTNAME")
    @NotNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "REGISTERDATE")
    @NotNull
    public LocalDate getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(LocalDate registerdate) {
        this.registerdate = registerdate;
    }
}
