package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookContainer;
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

//    @Test
//    void testGetBookFromDatabaseAndPutInContainer() {
//        BookContainer bookContainer = new BookContainer("free");
//        Books book = booksDao.findAll().iterator().next();
//        bookContainer.setBooks(book);
//
//        bookContainerDao.save(bookContainer);
//        int id = bookContainer.getId();
//
//        Assertions.assertNotEquals(0, id);
//
//        bookContainerDao.deleteById(id);
//    }

    @Test
    void testBookContainerDao() {
        BookContainer bookContainer = new BookContainer("free");
        bookContainer.setBooks(new Books("TEST TITLE", "TEST AUTHOR", RELEASE_DATE));

        int counterBefore = (int) bookContainerDao.count();
        bookContainerDao.save(bookContainer);
        int countAfter = (int) bookContainerDao.count();

        Assertions.assertNotEquals(counterBefore, countAfter);

        bookContainerDao.deleteById(bookContainer.getId());
    }
}
