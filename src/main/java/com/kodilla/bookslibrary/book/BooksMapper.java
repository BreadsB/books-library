package com.kodilla.bookslibrary.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksMapper {

    public Books mapToBooks(final BooksDto booksDto) {
        Books converted = new Books();
        converted.setId(booksDto.getId());
        converted.setTitle(booksDto.getTitle());
        converted.setAuthor(booksDto.getAuthor());
        converted.setReleaseDate(booksDto.getReleaseDate());

        return converted;
    }

    public BooksDto mapToBooksDto(final Books books) {
        return new BooksDto(
                books.getId(),
                books.getTitle(),
                books.getAuthor(),
                books.getReleaseDate()
        );
    }

    public List<BooksDto> mapToBooksDtoList(final List<Books> booksList) {
        return booksList.stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }
}
