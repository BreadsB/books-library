package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.customer.Customers;
import com.kodilla.bookslibrary.customer.CustomersDao;
import com.kodilla.bookslibrary.rents.Rents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Isolated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("h2database")
public class CustomersDaoTestSuite {

    @Autowired
    private CustomersDao customersDao;
    private static final LocalDate REGISTER_DATE = LocalDate.of(1990,2,6);

    @Test
    void testCreateNewCustomer() {
        Customers customer = new Customers();
        customer.setFirstname("FIRST");
        customer.setLastname("LAST");
        customer.setRegisterdate(REGISTER_DATE);
        customersDao.save(customer);
        int id = customer.getId();
        Optional<Customers> findCustomer = customersDao.findById(id);
        Assertions.assertTrue(findCustomer.isPresent());

        customersDao.deleteById(id);
    }

    @Test
    void testUpdateCustomer() {
        Customers customer = new Customers();
        customer.setFirstname("FIRST");
        customer.setLastname("LAST");
        customer.setRegisterdate(REGISTER_DATE);
        int id = customer.getId();
        customersDao.save(customer);

        Customers customerUpdate = new Customers(id, "Mike", "Brownson", LocalDate.now(), new ArrayList<Rents>());
        customersDao.save(customerUpdate);
        Optional<Customers> result = customersDao.findById(customerUpdate.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Brownson", result.get().getLastname());
        customersDao.deleteById(1);
    }

    @Test
    void testFindAllCustomers() {

        Customers customer1 = new Customers();
        Customers customer2 = new Customers();

        customer1.setFirstname("FIRST");
        customer1.setLastname("LAST");
        customer1.setRegisterdate(REGISTER_DATE);

        customer2.setFirstname("Second");
        customer2.setLastname("LAST");
        customer2.setRegisterdate(REGISTER_DATE);

        customersDao.save(customer1);
        customersDao.save(customer2);

        List<Customers> result = (List<Customers>) customersDao.findAll();
        result.forEach(customers -> System.out.println(customers.getId()));
        result.forEach(customers -> System.out.println(customers.getFirstname()));
        Assertions.assertEquals(2, result.size());

        customersDao.deleteById(customer1.getId());
        customersDao.deleteById(customer2.getId());
    }
}