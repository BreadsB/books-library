package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.bookposition.BookPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
    @Query
    List<BookPosition> retrieveBooksByStatus(@Param("STATUS") String status);

    @Override
    List<BookPosition> findAll();
}
