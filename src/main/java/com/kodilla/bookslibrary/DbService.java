package com.kodilla.bookslibrary;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.book.BooksDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BooksDao booksDao;

    public List<Books> getAllBooks() {
        return booksDao.findAll();
    }
}
