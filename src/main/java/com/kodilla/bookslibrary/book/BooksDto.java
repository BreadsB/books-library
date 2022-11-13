package com.kodilla.bookslibrary.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BooksDto {
    private int id;
    private String title;
    private String author;
    private LocalDate releaseDate;
}
