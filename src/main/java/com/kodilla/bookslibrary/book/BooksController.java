package com.kodilla.bookslibrary.book;

import com.kodilla.bookslibrary.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final DbService dbService;
    private final BooksMapper booksMapper;

    @GetMapping
    public List<BooksDto> getBooks() {
        return booksMapper.mapToBooksDtoList(dbService.getAllBooks());
    }

    @GetMapping(value = "{bookId}")
    public BooksDto getBook(@PathVariable int bookId) {
        return new BooksDto(1, "SAMPLE BOOK", "SAMPLE AUTHOR", LocalDate.now());
    }

    @DeleteMapping
    public void deleteBook(int bookId) {
    }

    @PutMapping
    public BooksDto updateBook(BooksDto booksDto) {
        return new BooksDto(1, "UPDATED SAMPLE BOOK", "UPDATED SAMPLE AUTHOR", LocalDate.now().minusDays(1));
    }

    @PostMapping
    public void createBook(BooksDto booksDto) {

    }
}
