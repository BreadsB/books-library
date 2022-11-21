package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.customer.Customers;
import com.kodilla.bookslibrary.customer.CustomersDao;
import com.kodilla.bookslibrary.rents.Rents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("h2database")
public class CustomersDaoTestSuite {

    @Autowired
    private CustomersDao customersDao;
    private static final LocalDate REGISTER_DATE = LocalDate.of(1990,2,6);

    @Test
    void testCustomersDao() {
        Customers customer1 = new Customers(1, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());

        customersDao.save(customer1);
        int id = customer1.getId();
        Optional<Customers> findCustomer = customersDao.findById(id);
        Assertions.assertTrue(findCustomer.isPresent());

        customersDao.deleteById(id);
    }
}
