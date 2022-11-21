package com.kodilla.bookslibrary.rents;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentsMapper {
    public RentsDto mapToDto(Rents rent) {
        return new RentsDto(
                rent.getId(),
                rent.getRentDate(),
                rent.getReturnDate(),
                rent.getCustomers(),
                rent.getBookPosition()
        );
    }

    public List<RentsDto> mapToDtoList(List<Rents> allRents) {
        return allRents.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Rents mapToEntity(RentsDto body) {
        return new Rents(
                body.getId(),
                body.getRentDate(),
                body.getReturnDate(),
                body.getCustomers(),
                body.getBookPosition()
        );
    }
}