package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.exceptions.CustomerNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomersController {

    private final CustomersService service;
    private final CustomersMapper mapper;

    @GetMapping(value = "/{id}")
    CustomersDto getCustomer(@PathVariable int id) throws CustomerNotFound {
        return mapper.convertToCustomerDto(service.getCustomerById(id));
    }

    @GetMapping
    List<CustomersDto> getAllCustomers() {
        return mapper.convertToCustomerDtoList(service.getAllCustomers());
    }

    @PostMapping
    void createCustomer() {}

    @PutMapping(value = "/{id}")
    void updateCustomer(@PathVariable int id, @RequestBody CustomersDto customersDto) throws CustomerNotFound {
        service.updateCustomer(id, mapper.convertToCustomer(customersDto));
    }

    @DeleteMapping(value = "/{id}")
    void deleteCustomer(@PathVariable int id) throws CustomerNotFound {
        service.deleteCustomer(id);
    }
}
