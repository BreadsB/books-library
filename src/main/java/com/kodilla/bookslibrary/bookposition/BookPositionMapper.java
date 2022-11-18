package com.kodilla.bookslibrary.bookposition;

import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookPositionMapper {

    BookPosition convertToBookPosition(final BookPositionDto bookPositionDto) {
        BookPosition converted = new BookPosition();
        converted.setStatus(bookPositionDto.getStatus());
        converted.setBooks(bookPositionDto.getBooks());
        converted.setRents(bookPositionDto.getRents());
        return converted;
    }

    BookPositionDto convertToBookPositionDto(final BookPosition bookPosition) {
        return new BookPositionDto(
                bookPosition.getId(),
                bookPosition.getStatus(),
                bookPosition.getBooks(),
                bookPosition.getRents()
        );
    }
}
