package com.kodilla.bookslibrary.exceptions;

public class BooksNotFoundException extends Exception {

    public BooksNotFoundException() {
        super("No books in database!");
    }
}
