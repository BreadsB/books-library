package com.kodilla.bookslibrary.rents;

import com.kodilla.bookslibrary.rents.Rents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RentsDao extends CrudRepository<Rents, Integer> {
}
