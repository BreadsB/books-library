package com.kodilla.bookslibrary.exceptions;

public class BooksNotFoundException extends Exception {

    public BooksNotFoundException() {
        super("Couldn't find book with that id");
    }
}
