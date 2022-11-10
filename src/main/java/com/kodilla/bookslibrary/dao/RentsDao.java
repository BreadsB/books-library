package com.kodilla.bookslibrary.dao;

import com.kodilla.bookslibrary.entities.Rents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RentsDao extends CrudRepository<Rents, Integer> {
}
