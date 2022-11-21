package com.kodilla.bookslibrary.rents;

import com.kodilla.bookslibrary.exceptions.RentsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rents")
public class RentsController {

    private final RentsService service;
    private final RentsMapper mapper;


    @GetMapping(value = "{id}")
    ResponseEntity<RentsDto> getRent(@PathVariable int id) throws RentsNotFoundException {
        return ResponseEntity.ok(mapper.mapToDto(service.getRent(id)));
    }

    @GetMapping
    ResponseEntity<List<RentsDto>> getAllRents() {
        return ResponseEntity.ok(mapper.mapToDtoList(service.getAllRents()));
    }

    @PostMapping
    ResponseEntity<Void> createRent(@RequestBody RentsDto body) {
        service.save(mapper.mapToEntity(body));
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{id}")
    ResponseEntity<Void> updateRent(@PathVariable int id, @RequestBody RentsDto detailsDto) throws RentsNotFoundException {
        service.update(id, mapper.mapToEntity(detailsDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{id}")
    ResponseEntity<Void> deleteRent(@PathVariable int id) throws RentsNotFoundException {
        service.deleteRent(id);
        return ResponseEntity.ok().build();
    }
}