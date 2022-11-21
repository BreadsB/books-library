package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.rents.Rents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstname;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastname;

    @Column(name = "REGISTERDATE")
    @NotNull
    private LocalDate registerdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private List<Rents> rents = new ArrayList<>();
}