package com.kodilla.bookslibrary.book;

import com.kodilla.bookslibrary.DbService;
import com.kodilla.bookslibrary.exceptions.BooksNotFoundException;
import com.kodilla.bookslibrary.exceptions.GlobalHttpErrorHandler;
import com.kodilla.bookslibrary.exceptions.BookNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
//@RequiredArgsConstructor
public class BooksController {

    private final DbService dbService;
    private final BooksMapper booksMapper;


    BooksController(DbService dbService, BooksMapper booksMapper) {
        this.dbService = dbService;
        this.booksMapper = booksMapper;
    }

    @GetMapping
    public ResponseEntity<List<BooksDto>> getBooks() throws BooksNotFoundException {
        return ResponseEntity.ok(booksMapper.mapToBooksDtoList(dbService.getAllBooks()));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BooksDto> getBook(@PathVariable int bookId) throws BookNotFoundException {
            return ResponseEntity.ok(booksMapper.mapToBooksDto(dbService.getBookById(bookId)));
    }

    @DeleteMapping
    public void deleteBook(int bookId) {

    }

    @PutMapping
    public BooksDto updateBook(@RequestBody BooksDto booksDto) {
        return new BooksDto(booksDto.getId(), booksDto.getTitle(), booksDto.getAuthor(), booksDto.getReleaseDate());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BooksDto booksDto) {
        dbService.saveBook( booksMapper.mapToBooks(booksDto) );
    }
}