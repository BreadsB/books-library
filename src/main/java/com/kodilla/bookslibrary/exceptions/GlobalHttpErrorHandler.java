package com.kodilla.bookslibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFound(BookNotFoundException exception) {
        return new ResponseEntity<>("Book with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BooksNotFoundException.class)
    public String handleBooksNotFoundException(BooksNotFoundException exception) {
        return exception.getMessage();
    }
}