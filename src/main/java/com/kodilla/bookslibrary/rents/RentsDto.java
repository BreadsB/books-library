package com.kodilla.bookslibrary.rents;

import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.customer.Customers;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentsDto {
    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Customers customers;
    private BookPosition bookPosition;
}
