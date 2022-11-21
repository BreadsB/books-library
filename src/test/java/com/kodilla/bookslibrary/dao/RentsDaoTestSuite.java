package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.bookposition.BookPosition;
import com.kodilla.bookslibrary.customer.Customers;
import com.kodilla.bookslibrary.rents.Rents;
import com.kodilla.bookslibrary.rents.RentsDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("h2database")
public class RentsDaoTestSuite {

    @Autowired
    RentsDao rentsDao;

    @Test
    void testCreateNewRent() {

        Rents rentsTest = new Rents();

        rentsDao.save(rentsTest);

        Optional<Rents> result = rentsDao.findById(rentsTest.getId());
        Assertions.assertTrue(result.isPresent());
    }
}
