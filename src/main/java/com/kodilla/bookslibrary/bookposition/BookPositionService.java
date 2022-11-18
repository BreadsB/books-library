package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.exceptions.BookPositionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookPositionService {

    BookPositionDao bookPositionDao;

    List<BookPosition> getAllBookPositions() {
        return bookPositionDao.findAll();
    }

    BookPosition getBookPositionById(int id) throws BookPositionNotFoundException {
        return bookPositionDao.findById(id).orElseThrow(BookPositionNotFoundException::new);
    }

    void deleteBookPositionById() {}

    void createBookPosition(BookPosition bookPosition) {
        bookPositionDao.save(bookPosition);
    }

    void updateBookPosition(int id, BookPosition bookPosition) throws BookPositionNotFoundException {
        BookPosition update = bookPositionDao.findById(id).orElseThrow(BookPositionNotFoundException::new);

        update.setStatus(bookPosition.getStatus());
        update.setBooks(bookPosition.getBooks());
        update.setRents(bookPosition.getRents());

        bookPositionDao.save(update);
    }
}