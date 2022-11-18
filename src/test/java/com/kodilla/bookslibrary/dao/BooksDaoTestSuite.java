package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("h2database")
public class BooksDaoTestSuite {

    @Autowired
    private BooksDao booksDao;

    @Test
    void testAddNewBook() {
        Books testBook = new Books("Test Title", "Test Author", LocalDate.now());

        booksDao.save(testBook);
        int id = testBook.getId();
        Optional<Books> book = booksDao.findById(id);
        Assertions.assertTrue(book.isPresent());

        booksDao.deleteById(id);
    }

    @Test
    void testFindAllBooks() {
        Books book1 = new Books("Test Title", "Test Author", LocalDate.now());
        Books book2 = new Books("Test Title", "Test Author", LocalDate.now());

        booksDao.save(book1);
        booksDao.save(book2);

        List<Books> booksList = booksDao.findAll();
        Assertions.assertNotEquals(0, booksList.size());

        booksDao.deleteById(book1.getId());
        booksDao.deleteById(book2.getId());
    }
}
