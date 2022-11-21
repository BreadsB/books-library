package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.exceptions.BookPositionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookPositionService {

    private final BookPositionDao bookPositionDao;

    List<BookPosition> getAllBookPositions() {
        return bookPositionDao.findAll();
    }

    BookPosition getBookPositionById(int id) throws BookPositionNotFoundException {
        return bookPositionDao.findById(id).orElseThrow(BookPositionNotFoundException::new);
    }

    void deleteBookPositionById(int id) throws BookPositionNotFoundException {
        bookPositionDao.findById(id).orElseThrow(BookPositionNotFoundException::new);
        bookPositionDao.deleteById(id);
    }

    void createBookPosition(BookPosition bookPosition) {
        bookPositionDao.save(bookPosition);
    }

    void updateBookPosition(int id, BookPosition bookPosition) throws BookPositionNotFoundException {
        BookPosition update = bookPositionDao.findById(id).orElseThrow(BookPositionNotFoundException::new);

        update.setStatus(bookPosition.getStatus());

        bookPositionDao.save(update);
    }
}