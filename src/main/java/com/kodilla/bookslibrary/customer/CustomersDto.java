package com.kodilla.bookslibrary.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CustomersDto {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate registerDate;
}
