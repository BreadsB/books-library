package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import com.kodilla.bookslibrary.entities.Customers;
import com.kodilla.bookslibrary.entities.Rents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RentsDaoTestSuite {

    @Autowired
    RentsDao rentsDao;

    @Test
    void testCreateNewRent() {
        Books bookTest = new Books(
                "RENTDAO TEST",
                "RENTDAOTEST CUSTOMER",
                LocalDate.of(2000,10,10)
        );
        BookPosition bookPositionTest = new BookPosition("RENTDAO TEST status");
        Customers customersTest = new Customers("Adam", "Nowak", LocalDate.now().minusMonths(1));
        Rents rentsTest = new Rents(LocalDate.now(), LocalDate.now().plusDays(5));

        bookPositionTest.setBooks(bookTest);
        rentsTest.setBookContainer(bookPositionTest);
        rentsTest.setCustomers(customersTest);

        Long countBefore = rentsDao.count();
        rentsDao.save(rentsTest);
        Long countAfter = rentsDao.count();

        Assertions.assertTrue(countBefore < countAfter, "Rent is properly saved!");

        rentsDao.deleteById(rentsTest.getId());
    }
}
