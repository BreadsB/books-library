package com.kodilla.bookslibrary.book;

import com.kodilla.bookslibrary.book.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BooksDao extends CrudRepository<Books, Integer> {

    List<Books> findAll();
}
