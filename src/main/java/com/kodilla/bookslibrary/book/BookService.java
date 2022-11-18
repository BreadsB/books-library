package com.kodilla.bookslibrary.book;

import com.kodilla.bookslibrary.exceptions.BookNotFoundException;
import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class BookService {

    private final BooksDao booksDao;

    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<Books> getAllBooks() {
        return booksDao.findAll();
    }

    public Books getBookById(final int id) throws BookNotFoundException {
        return booksDao.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Books saveBook(final Books book) {
        return booksDao.save(book);
    }

    public void deleteBookById(final int id) {

        if (booksDao.existsById(id)) {
            booksDao.deleteById(id);
        }
    }

}
