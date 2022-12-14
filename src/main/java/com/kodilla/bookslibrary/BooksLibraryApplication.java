package com.kodilla.bookslibrary;

import com.kodilla.bookslibrary.book.BooksDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BooksLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksLibraryApplication.class, args);
    }

}
