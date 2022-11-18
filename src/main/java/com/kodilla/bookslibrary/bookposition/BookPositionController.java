package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.exceptions.BookPositionNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookposition")
public class BookPositionController {

    private final BookPositionService service;
    private final BooksPositionMapper mapper;

    @GetMapping(value = "{id}")
    BookPositionDto getBookPosition(@PathVariable int id) throws BookPositionNotFoundException {
        return mapper.convertToBookPositionDto(service.getBookPositionById(id));
    }

    @GetMapping
    List<BookPositionDto> getAllBookPositions() {
        return service.getAllBookPositions().stream()
                .map(mapper::convertToBookPositionDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    void createBookPosition(BookPosition bookPosition) {
        service.createBookPosition(bookPosition);
    }

    @PutMapping("{bookPositionId}")
    void updateBookPosition(@PathVariable int bookPositionId, @RequestBody BookPosition bookPosition) throws BookPositionNotFoundException {
        service.updateBookPosition(bookPositionId, bookPosition);
    }

    void deleteBookPosition() {

    }
}
