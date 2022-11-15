package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.bookposition.BookPositionDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.kodilla.bookslibrary.dao.BooksDaoTestSuite.RELEASE_DATE;

@SpringBootTest
public class BookPositionDaoTestSuite {

    @Autowired
    BookPositionDao bookPositionDao;

    @Test
    void testBookContainerDao() {
        BookPosition bookPosition1 = new BookPosition("free");

        Books book1 = new Books(1, "BookPositionDaoTest1", "BookPositionDaoTest1", RELEASE_DATE);
        book1.getBookPositions().add(bookPosition1);

        bookPosition1.setBooks(book1);

        long countBefore = bookPositionDao.count();
        bookPositionDao.save(bookPosition1);
        long countAfter = bookPositionDao.count();

        Assertions.assertTrue(countAfter > countBefore);

        bookPositionDao.deleteById(bookPosition1.getId());
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
