package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import com.kodilla.bookslibrary.entities.Customers;
import com.kodilla.bookslibrary.entities.Rents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import java.time.LocalDate;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RentsDaoTestSuite {

    EntityManager em;

    @Autowired
    RentsDao rentsDao;

   /* @Test
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
        bookTest.getBookPositions().add(bookPositionTest);

        rentsTest.setBookPosition(bookPositionTest);
        rentsTest.setCustomers(customersTest);
        bookPositionTest.setRents(rentsTest);
        customersTest.getRents().add(rentsTest);

        long countBefore = rentsDao.count();
        rentsDao.save(rentsTest);
        long countAfter = rentsDao.count();

        Assertions.assertTrue(countAfter>countBefore);
    }*/
}
