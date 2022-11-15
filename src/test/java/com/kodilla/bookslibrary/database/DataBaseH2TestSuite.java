package com.kodilla.bookslibrary.database;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.bookposition.BookPositionDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2database")
public class DataBaseH2TestSuite {

    @Autowired
    BooksDao booksDao;
    @Autowired
    BookPositionDao bookPositionDao;

    @Test
    void testBooksNotFoundException() {
        List<Books> booksList = booksDao.findAll();
        System.out.println(booksList.size());
    }

    @Test
    void testNoBookPositionTestSuite() {
        List<BookPosition> bookPositionList = bookPositionDao.retrieveBooksByStatus("LOST");
        System.out.println(bookPositionList.size());
    }

}