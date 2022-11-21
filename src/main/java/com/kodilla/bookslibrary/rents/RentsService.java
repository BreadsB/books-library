package com.kodilla.bookslibrary.rents;

import com.kodilla.bookslibrary.exceptions.CustomerNotFound;
import com.kodilla.bookslibrary.exceptions.RentsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentsService {
    private final RentsDao repository;

    Rents getRent(int id) throws RentsNotFoundException {
        return repository.findById(id).orElseThrow(RentsNotFoundException::new);
    }

    public List<Rents> getAllRents() {
        return (List<Rents>) repository.findAll();
    }

    public void save(Rents body) {
        repository.save(body);
    }

    public void update(int id, Rents details) throws RentsNotFoundException {
        repository.findById(id).orElseThrow(RentsNotFoundException::new);
        repository.save(details);
    }

    public void deleteRent(int id) throws RentsNotFoundException {
        repository.findById(id).orElseThrow(RentsNotFoundException::new);
        repository.deleteById(id);
    }
}