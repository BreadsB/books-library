package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.rents.Rents;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    private int id;
    private String firstname;
    private String lastname;
    private LocalDate registerdate;
    private List<Rents> rents = new ArrayList<>();

    public Customers() {}

    public Customers(String firstname, String lastname, LocalDate registerdate) {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers", fetch = FetchType.LAZY)
    public List<Rents> getRents() {
        return rents;
    }

    public void setRents(List<Rents> rents) {
        this.rents = rents;
    }
}
