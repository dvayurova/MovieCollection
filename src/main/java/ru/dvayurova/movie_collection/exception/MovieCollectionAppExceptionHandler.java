package ru.dvayurova.movie_collection.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.dvayurova.movie_collection.service.MovieService;


@ControllerAdvice
public class MovieCollectionAppExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMovieNotFoundException(MovieNotFoundException e){
        logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleInvalidInputException(InvalidInputException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }
}
