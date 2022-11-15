package com.kodilla.bookslibrary.exceptions;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksController;
import com.kodilla.bookslibrary.book.BooksDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("h2database")
public class ExcetpionsTestSuite {

//    @Autowired
    @MockBean
    BooksDao booksDao;
}