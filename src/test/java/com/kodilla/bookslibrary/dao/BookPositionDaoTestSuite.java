package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kodilla.bookslibrary.dao.BooksDaoTestSuite.RELEASE_DATE;

@SpringBootTest
public class BookPositionDaoTestSuite {

    @Autowired
    BookPositionDao bookPositionDao;

    @Test
    void testBookContainerDao() {
        BookPosition bookPosition1 = new BookPosition("free");

        Books book1 = new Books("BookPositionDaoTest1", "BookPositionDaoTest1", RELEASE_DATE);

        book1.getBookPositions().add(bookPosition1);

        bookPosition1.setBooks(book1);

        long countBefore = bookPositionDao.count();
        bookPositionDao.save(bookPosition1);
        long countAfter = bookPositionDao.count();

        Assertions.assertTrue(countAfter > countBefore);
    }
}
