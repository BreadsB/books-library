package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookPosition;
import com.kodilla.bookslibrary.entities.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookPositionDao extends CrudRepository<BookPosition, Integer> {

    @Query
    List<BookPosition> retrieveLostBooks();
    @Query
    List<BookPosition> retrieveRentedBooks();
}
