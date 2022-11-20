package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.exceptions.BookPositionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookposition")
public class BookPositionController {

    private final BookPositionService service;
    private final BookPositionMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookPositionDto> getBookPosition(@PathVariable int id) throws BookPositionNotFoundException {
        return ResponseEntity.ok(mapper.convertToBookPositionDto(service.getBookPositionById(id)));
    }

    @GetMapping
    public ResponseEntity<List<BookPositionDto>> getAllBookPositions() {
        return ResponseEntity.ok(mapper.convertToBookPositionDtoList(service.getAllBookPositions()));
    }

    @PostMapping
    ResponseEntity<Void> createBookPosition(BookPositionDto bookPositionDto) {
        service.createBookPosition(mapper.convertToBookPosition(bookPositionDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{bookPositionId}")
    ResponseEntity<Void> updateBookPosition(
            @PathVariable int bookPositionId,
            @RequestBody BookPosition bookPosition
    ) throws BookPositionNotFoundException {
        service.updateBookPosition(bookPositionId, bookPosition);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBookPosition(@PathVariable int id) {
        service.deleteBookPositionById(id);
        return ResponseEntity.ok().build();
    }
}