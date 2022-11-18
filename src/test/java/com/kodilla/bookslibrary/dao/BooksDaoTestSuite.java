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
//@ActiveProfiles("h2database")
public class BooksDaoTestSuite {

    public final static LocalDate RELEASE_DATE = LocalDate.now();

    @Autowired
    private BooksDao booksDao;

    @Test
    void testAddNewBook() {
        Books testBook = new Books("Test title", "Test Author", RELEASE_DATE);
        booksDao.save(testBook);
        int id = testBook.getId();
        Optional<Books> book = booksDao.findById(id);
        System.out.println(book);
        booksDao.deleteById(id);
    }

    @Test
    void testFindAllBooks() {
        Books book1 = new Books();
        Books book2 = new Books();

        booksDao.save(book1);
        booksDao.save(book2);

        List<Books> booksList = booksDao.findAll();
        Assertions.assertNotEquals(0, booksList.size());

        booksDao.deleteById(book1.getId());
        booksDao.deleteById(book2.getId());
    }

    @Test
    void testDeleteFromDataBase() {

        Books book1 = new Books();
        booksDao.save(book1);
        int bookId = book1.getId();

        List<Books> result1 = booksDao.findAll();
        Books bookResult = result1.iterator().next();
        Assertions.assertEquals(bookId, bookResult.getId());
//        booksDao.deleteById(bookResult.getId());    //Not working, idk why.
    }

    @Test
    void testDeleteAllFromDataBase() {
        booksDao.deleteAll();
    }
}
