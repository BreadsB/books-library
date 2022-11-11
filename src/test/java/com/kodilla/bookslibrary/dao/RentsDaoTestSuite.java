package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import com.kodilla.bookslibrary.entities.Customers;
import com.kodilla.bookslibrary.entities.Rents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RentsDaoTestSuite {

    @Autowired
    RentsDao rentsDao;

    @Test
    void testCreateNewRent() {
        Books bookTest = new Books(
                "Flying in forest",
                "Camila Newman",
                LocalDate.of(2008,10,10)
        );
        BookPosition bookPosition1Test = new BookPosition("LOST");
        BookPosition bookPosition2Test = new BookPosition("RENTED");
        Customers customersTest = new Customers("Janusz", "Prycz", LocalDate.now().minusMonths(1));
        Customers customersTest2 = new Customers("Karol", "Bajgiel", LocalDate.now().minusMonths(1));
        Rents rentsTest = new Rents(LocalDate.now(), LocalDate.now().plusDays(5));
        Rents rentsTest2 = new Rents(LocalDate.now(), LocalDate.now().plusDays(15));

        bookPosition1Test.setBooks(bookTest);
        bookPosition2Test.setBooks(bookTest);
        bookTest.getBookPositions().add(bookPosition1Test);
        bookTest.getBookPositions().add(bookPosition2Test);

        rentsTest.setBookPosition(bookPosition1Test);
        rentsTest2.setBookPosition(bookPosition2Test);
        rentsTest.setCustomers(customersTest);
        rentsTest2.setCustomers(customersTest2);
        bookPosition1Test.setRents(rentsTest);
        bookPosition2Test.setRents(rentsTest2);
        customersTest.getRents().add(rentsTest);
        customersTest2.getRents().add(rentsTest2);

        long countBefore = rentsDao.count();
        rentsDao.save(rentsTest);
        long countAfter = rentsDao.count();

        Assertions.assertTrue(countAfter>countBefore);
    }
}
