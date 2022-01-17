package com.example.awsrdsspringbootapp.exception;

public class InvalidFileException extends RuntimeException {
    public InvalidFileException() {
    }

    public InvalidFileException(String message) {
        super(message);
    }
}
