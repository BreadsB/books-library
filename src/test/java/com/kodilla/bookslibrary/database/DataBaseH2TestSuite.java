package com.kodilla.bookslibrary.database;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.bookposition.BookPositionDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2database")
public class DataBaseH2TestSuite {

    @Autowired
    BooksDao booksDao;

    @Test
    void testBookListSizeShouldBeZero() {
        List<Books> booksList = booksDao.findAll();
        Assertions.assertEquals(0, booksList.size());
    }

    @Test
    void testAddNewBookToH2DataBase() {

        Books testBook = new Books(1, "H2 Database", "H2 Database", LocalDate.of(2008,7,14));

        booksDao.save(testBook);

        System.out.println(booksDao.findAll().size());

        int result = testBook.getId();
        Optional<Books> book = booksDao.findById(result);
        Assertions.assertTrue(book.isPresent());

    }
}