package com.kodilla.bookslibrary.bookposition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class BookPositionController {

    BookPositionService bookPositionService;
}
