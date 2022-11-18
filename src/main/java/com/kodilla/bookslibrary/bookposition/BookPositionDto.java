package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.rents.Rents;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookPositionDto {
    private int id;
    private String status;
    private Books books;
    private Rents rents;
}
