package com.kodilla.bookslibrary.customer;

import com.kodilla.bookslibrary.rents.Rents;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersMapper {

    Customers convertToCustomer(CustomersDto customersDto) {
        Customers converted = new Customers();
        converted.setId(customersDto.getId());
        converted.setFirstname(customersDto.getFirstname());
        converted.setLastname(customersDto.getLastname());
        converted.setRegisterdate(customersDto.getRegisterDate());
        converted.setRents(customersDto.getRents());

        return converted;
    }

    CustomersDto convertToCustomerDto(Customers customers) {
        CustomersDto converted = new CustomersDto();
        converted.setId(customers.getId());
        converted.setFirstname(customers.getFirstname());
        converted.setLastname(customers.getLastname());
        converted.setRegisterDate(customers.getRegisterdate());
        converted.setRents(customers.getRents());

        return converted;
    }

    public List<CustomersDto> convertToCustomerDtoList(List<Customers> allCustomers) {
        return allCustomers.stream()
                .map(this::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
