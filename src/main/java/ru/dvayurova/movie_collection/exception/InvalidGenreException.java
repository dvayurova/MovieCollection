package ru.dvayurova.movie_collection.exception;

public class InvalidGenreException extends RuntimeException {
    public InvalidGenreException(String message) {
        super(message);
    }
}

