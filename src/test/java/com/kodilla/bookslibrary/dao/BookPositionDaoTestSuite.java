package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class BookPositionDaoTestSuite {

    public final static LocalDate RELEASE_DATE = LocalDate.of(2000,5,6);
    @Autowired
    BookPositionDao bookPositionDao;

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
        BookPosition bookPosition1 = new BookPosition("BookPositionTest1");
        BookPosition bookPosition2 = new BookPosition("BookPositionTest2");

        Books book1 = new Books("BookPositionTest1", "BookPositionTest1", RELEASE_DATE);
        Books book2 = new Books("BookPositionTest2", "BookPositionTest2", RELEASE_DATE);

        bookPosition1.setBooks(book1);
        bookPosition2.setBooks(book2);

        book1.getBookPositions().add(bookPosition1);
        book2.getBookPositions().add(bookPosition2);

        long countBefore = bookPositionDao.count();

        bookPositionDao.save(bookPosition1);
        bookPositionDao.save(bookPosition2);

        long countAfter = bookPositionDao.count();

        Assertions.assertTrue(countAfter > countBefore);
    }
}
