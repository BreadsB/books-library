package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BooksDaoTestSuite {

    public final static LocalDate RELEASE_DATE = LocalDate.of(2000,5,6);

    @Autowired
    private BooksDao booksDao;

    @Test
    void testAddNewBook() {

        Books testBook = new Books("Test title", "Test Author", LocalDate.of(2008,7,14));

        booksDao.save(testBook);

        int result = testBook.getId();
        Optional<Books> book = booksDao.findById(result);
        Assertions.assertTrue(book.isPresent());

        booksDao.deleteById(result);
    }
}
