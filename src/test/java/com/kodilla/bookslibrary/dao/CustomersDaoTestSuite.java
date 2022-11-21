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
    void testCreateNewCustomer() {
        Customers customer1 = new Customers(1, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());

        customersDao.save(customer1);
        int id = customer1.getId();
        Optional<Customers> findCustomer = customersDao.findById(id);
        Assertions.assertTrue(findCustomer.isPresent());

        customersDao.deleteById(id);
    }

    @Test
    void testUpdateCustomer() {
        Customers customer1 = new Customers(1, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());
        customersDao.save(customer1);

        Customers customerUpdate = new Customers(1, "Mike", "Brownson", LocalDate.now(), new ArrayList<Rents>());
        customersDao.save(customerUpdate);
        Optional<Customers> result = customersDao.findById(customerUpdate.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Brownson", result.get().getLastname());
    }

    @Test
    void testFindAllCustomers() {
        Customers customer1 = new Customers(1, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());
        Customers customer2 = new Customers(2, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());
        Customers customer3 = new Customers(3, "Mike", "Littleson", REGISTER_DATE, new ArrayList<Rents>());

        customersDao.save(customer1);
        customersDao.save(customer2);
        customersDao.save(customer3);

        long result = customersDao.count();
        Assertions.assertEquals(3, result);
    }
}