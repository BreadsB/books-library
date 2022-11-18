package com.kodilla.bookslibrary.book;

import com.kodilla.bookslibrary.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
//@RequiredArgsConstructor
public class BooksController {

    private final BookService dbService;
    private final BooksMapper booksMapper;


    BooksController(BookService dbService, BooksMapper booksMapper) {
        this.dbService = dbService;
        this.booksMapper = booksMapper;
    }

    @GetMapping
    public ResponseEntity<List<BooksDto>> getBooks() {
        return ResponseEntity.ok(booksMapper.mapToBooksDtoList(dbService.getAllBooks()));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BooksDto> getBook(@PathVariable int bookId) throws BookNotFoundException {
            return ResponseEntity.ok(booksMapper.mapToBooksDto(dbService.getBookById(bookId)));
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
        dbService.deleteBookById(bookId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BooksDto> updateBook(@RequestBody BooksDto booksDto) {
        Books book = booksMapper.mapToBooks(booksDto);
        Books savedBook = dbService.saveBook(book);
        return ResponseEntity.ok(booksMapper.mapToBooksDto(savedBook));
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BooksDto booksDto) {
        dbService.saveBook( booksMapper.mapToBooks(booksDto) );
        return ResponseEntity.ok().build();
    }
}