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
        BookPosition bookPosition = new BookPosition("TEST");

        long countBefore = bookPositionDao.count();
        bookPositionDao.save(bookPosition);
        long countAfter = bookPositionDao.count();

        Assertions.assertTrue(countAfter > countBefore);

        bookPositionDao.deleteById(bookPosition.getId());
    }

    @Test
    void testRetrieveLostBooksQuery() {

        BookPosition bookPosition = new BookPosition("LOST");
        bookPositionDao.save(bookPosition);
        List<BookPosition> lostBooks = bookPositionDao.retrieveLostBooks();
        Assertions.assertEquals(1, lostBooks.size());
    }

    @Test
    void testRetrieveRentedBooksQuery() {
        BookPosition bookPosition = new BookPosition("RENTED");
        bookPositionDao.save(bookPosition);
        List<BookPosition> rentedBooks = bookPositionDao.retrieveRentedBooks();
        Assertions.assertEquals(1, rentedBooks.size());
    }

    @Test
    void testRetrieveBooksByStatus() {
        String status = "FREE";
        BookPosition bookPosition = new BookPosition(status);
        bookPositionDao.save(bookPosition);
        List<BookPosition> bookPositionList = bookPositionDao.retrieveBooksByStatus(status);
        Assertions.assertEquals(1, bookPositionList.size());
    }
}
