package com.kodilla.bookslibrary.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFound(BookNotFoundException exception) {
        return new ResponseEntity<>("Book with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookPositionNotFoundException.class)
    public ResponseEntity<Object> handleBookPositionNotFound(BookPositionNotFoundException exception) {
        return new ResponseEntity<>("Book position with given id does not exist. Check your id.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    protected ResponseEntity<?> handleNoCustomerFound(RuntimeException exception, WebRequest request) {
        String responseBody = "No customer with id: " + request.getParameter("id") + " has been found";
        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }

    @ExceptionHandler(RentsNotFoundException.class)
    protected ResponseEntity<?> handleNoRentsFound(RentsNotFoundException exception) {
        return new ResponseEntity<>("No rent position found with given id.",HttpStatus.NO_CONTENT);
    }
}