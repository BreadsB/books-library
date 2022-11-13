package com.kodilla.bookslibrary;

import com.kodilla.bookslibrary.book.BooksDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BooksLibraryApplication {

    public static void main(String[] args) {

        BooksDto booksDto = new BooksDto(10,"DTO TEST", "DTO TEST", LocalDate.now());

        System.out.println(booksDto.getId() +" "+ booksDto.getAuthor() +" "+ booksDto.getReleaseDate());

        SpringApplication.run(BooksLibraryApplication.class, args);
    }

}
