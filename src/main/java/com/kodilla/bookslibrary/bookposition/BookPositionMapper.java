package com.kodilla.bookslibrary.bookposition;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookPositionMapper {

    BookPosition convertToBookPosition(final BookPositionDto bookPositionDto) {
        BookPosition converted = new BookPosition();
        converted.setStatus(bookPositionDto.getStatus());
//        converted.setBooks(bookPositionDto.getBooks());
//        converted.setRents(bookPositionDto.getRents());
        return converted;
    }

    BookPositionDto convertToBookPositionDto(final BookPosition bookPosition) {
        return new BookPositionDto(
                bookPosition.getId(),
                bookPosition.getStatus()
//                bookPosition.getBooks(),
//                bookPosition.getRents()
        );
    }

    List<BookPositionDto> convertToBookPositionDtoList(List<BookPosition> bookPositionList) {
        return bookPositionList.stream()
                .map(this::convertToBookPositionDto)
                .collect(Collectors.toList());
    }
}