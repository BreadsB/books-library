package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.rents.Rents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookPositionDto {
    private int id;
    private String status;
}