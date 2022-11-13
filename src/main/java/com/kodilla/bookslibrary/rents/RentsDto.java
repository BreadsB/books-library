package com.kodilla.bookslibrary.rents;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentsDto {
    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
