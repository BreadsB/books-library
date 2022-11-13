package com.kodilla.bookslibrary;

import com.kodilla.bookslibrary.exceptions.BookNotFoundException;
import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import com.kodilla.bookslibrary.exceptions.BooksNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class DbService {

    private final BooksDao booksDao;

    public DbService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<Books> getAllBooks() {
        return booksDao.findAll();
    }

    public Books getBookById(final int id) throws BookNotFoundException {
        return booksDao.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public void saveBook(final Books book) {
        booksDao.save(book);
    }

}
