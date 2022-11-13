package com.kodilla.bookslibrary.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksMapper {

    public Books mapToBooks(final BooksDto booksDto) {
        return new Books(
                booksDto.getId(),
                booksDto.getTitle(),
                booksDto.getAuthor(),
                booksDto.getReleaseDate()
        );
    }

    public BooksDto mapToBooksDto(final Books books) {
        return new BooksDto(books.getId(), books.getTitle(), books.getAuthor(), books.getReleaseDate());
    }

    public List<BooksDto> mapToBooksDtoList(final List<Books> booksList) {
        return booksList.stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }
}
