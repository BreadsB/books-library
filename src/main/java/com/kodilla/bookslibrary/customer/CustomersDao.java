package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.customer.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomersDao extends CrudRepository<Customers, Integer> {
}
