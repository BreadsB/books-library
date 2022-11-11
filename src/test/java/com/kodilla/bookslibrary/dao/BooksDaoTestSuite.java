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

    Books testBook = new Books("Test title", "Test Author", LocalDate.of(2008,7,14));
    public final static LocalDate RELEASE_DATE = LocalDate.of(2000,5,6);

    @Autowired
    private BooksDao booksDao;

    @Test
    void testDaoMethodsCreateFindDelete() {

        booksDao.save(testBook);

        int result = testBook.getId();
        Optional<Books> book = booksDao.findById(result);
        Assertions.assertTrue(book.isPresent());

        booksDao.deleteById(result);
    }

    @Test
    void testBooksDao() {
        BookPosition bookPosition1 = new BookPosition("free");
        BookPosition bookPosition2 = new BookPosition("rented");
        BookPosition bookPosition3 = new BookPosition("lost");

        Books book1 = new Books("booksDaoTest", "booksDaoTest", RELEASE_DATE);

        book1.getBookPositions().add(bookPosition1);
        book1.getBookPositions().add(bookPosition2);
        book1.getBookPositions().add(bookPosition3);

        bookPosition1.setBooks(book1);
        bookPosition2.setBooks(book1);
        bookPosition3.setBooks(book1);

        long countBefore = booksDao.count();
        booksDao.save(book1);
        long countAfter = booksDao.count();

        Assertions.assertTrue(countAfter > countBefore);
    }
}
