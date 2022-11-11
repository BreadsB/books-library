package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class BookContainerDaoTestSuite {

    public final static LocalDate RELEASE_DATE = LocalDate.of(2000,5,6);
    @Autowired
    BookContainerDao bookContainerDao;

    @Autowired
    BooksDao booksDao;

/*    @Test
    void testGetBookFromDatabaseAndPutInContainer() {
        BookPosition bookPosition = new BookPosition("free");
        Books book = booksDao.findAll().iterator().next();
        bookPosition.setBooks(book);

        bookContainerDao.save(bookPosition);
        int id = bookPosition.getId();

        Assertions.assertNotEquals(0, id);

        bookContainerDao.deleteById(id);
    }*/

    @Test
    void testBookContainerDao() {
        BookPosition bookPosition = new BookPosition("free");
        bookPosition.setBooks(new Books("TEST TITLE", "TEST AUTHOR", RELEASE_DATE));

        int counterBefore = (int) bookContainerDao.count();
        bookContainerDao.save(bookPosition);
        int countAfter = (int) bookContainerDao.count();

        Assertions.assertNotEquals(counterBefore, countAfter);

        bookContainerDao.deleteById(bookPosition.getId());
    }
}
