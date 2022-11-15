package com.kodilla.bookslibrary.exceptions;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksController;
import com.kodilla.bookslibrary.book.BooksDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
//@ActiveProfiles("h2database")
public class ExcetpionsTestSuite {

    @Autowired
    BooksDao booksDao;

    @Autowired
    BooksController booksController;

    @Test
    void testNoBooksInDataBase() {
        List<Books> booksList = booksDao.findAll();
        Assertions.assertEquals(0, booksList.size());
    }

    @Test
    void testDeleteFromDataBase() {
        Books book = booksDao.findAll().listIterator().next();
        booksDao.deleteById(book.getId());
    }

    @Test
    void contextLoads() {
        Assertions.assertNotNull(booksController);
    }
}