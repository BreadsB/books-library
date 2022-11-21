package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.rents.Rents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDto {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate registerDate;
    private List<Rents> rents;
}
