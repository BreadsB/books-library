package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.BookContainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookContainerDao extends CrudRepository<BookContainer, Integer> {
}
