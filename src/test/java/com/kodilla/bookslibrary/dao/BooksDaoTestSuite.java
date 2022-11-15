package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BooksDaoTestSuite {

    public final static LocalDate RELEASE_DATE = LocalDate.of(2000,5,6);

    @Autowired
    private BooksDao booksDao;

    @Test
    void testAddNewBook() {

        Books testBook = new Books(1, "Test title", "Test Author", LocalDate.of(2008,7,14));

        booksDao.save(testBook);

        int result = testBook.getId();
        Optional<Books> book = booksDao.findById(result);
        Assertions.assertTrue(book.isPresent());

        booksDao.deleteById(result);
    }

    @Test
    void testFindAllBooks() {
        List<Books> booksList = booksDao.findAll();
        Assertions.assertEquals(0, booksList.size());
    }

    @Test
    void testDeleteFromDataBase() {
        Books book = booksDao.findAll().listIterator().next();
        booksDao.deleteById(book.getId());
    }
}
