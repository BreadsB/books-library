package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.bookposition.BookPositionDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;


@SpringBootTest
@ActiveProfiles("h2database")
public class BookPositionDaoTestSuite {

    @Autowired
    BookPositionDao bookPositionDao;

    @Test
    void testAddNewBookPositionToRepository() {
        BookPosition bookPosition = new BookPosition(1, "TEST");

        long countBefore = bookPositionDao.count();
        bookPositionDao.save(bookPosition);
        long countAfter = bookPositionDao.count();

        Assertions.assertTrue(countAfter > countBefore);

        bookPositionDao.deleteById(bookPosition.getId());
    }

    @Test
    void testRetrieveLostBooksQuery() {

        String status = "LOST";
        List<BookPosition> lostBooks = bookPositionDao.retrieveLostBooks();

        if (lostBooks.isEmpty()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertNotEquals(0, lostBooks.size());
            Assertions.assertEquals(status, lostBooks.listIterator().next().getStatus());
        }
    }

    @Test
    void testRetrieveRentedBooksQuery() {

        String status = "RENTED";
        List<BookPosition> rentedBooks = bookPositionDao.retrieveRentedBooks();

        if (rentedBooks.isEmpty()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertNotEquals(0, rentedBooks.size());
            Assertions.assertEquals(status, rentedBooks.listIterator().next().getStatus());
        }
    }

    @Test
    void testRetrieveBooksByStatus() {
        String status = "free";
        List<BookPosition> bookPositionList = bookPositionDao.retrieveBooksByStatus(status);

        if (bookPositionList.isEmpty()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertNotEquals(0, bookPositionList.size());
            Assertions.assertEquals(status, bookPositionList.listIterator().next().getStatus());
        }
    }
}
