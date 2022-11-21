package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersService {

    private final CustomersDao customersDao;

    public Customers getCustomerById(int id) throws CustomerNotFoundException {
        return customersDao.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public List<Customers> getAllCustomers() {
        return (List<Customers>) customersDao.findAll();
    }

    public void createCustomer(Customers customer) {
        customersDao.save(customer);
    }

    public void updateCustomer(int id, Customers customerDetails) throws CustomerNotFoundException {
        Customers customer = customersDao.findById(id).orElseThrow(CustomerNotFoundException::new);
        customer.setFirstname(customerDetails.getFirstname());
        customer.setLastname(customerDetails.getLastname());
        customer.setRegisterdate(customerDetails.getRegisterdate());
        customer.setRents(customerDetails.getRents());
    }

    public void deleteCustomer(int id) {
        customersDao.deleteById(id);
    }
}