package ru.dvayurova.movie_collection.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.dvayurova.movie_collection.dto.MovieDto;
import ru.dvayurova.movie_collection.exception.InvalidInputException;
import ru.dvayurova.movie_collection.genres.MovieGenre;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieInputValidatorTest {

    @Test
    void shouldThrowExceptionWhenNoTitle() {
        MovieDto movieDto = MovieDto.builder()
                .releaseYear(2000)
                .director("Richi")
                .country("USA")
                .genre("ACTION")
                .build();
       Exception exception = Assertions.assertThrows(InvalidInputException.class,
               () -> {
                   MovieInputValidator.validate(movieDto);
               });
        String expectedMessage = "Please enter title";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowExceptionWhenIncorrectReleaseYear() {
        MovieDto movieDto = MovieDto.builder()
                .title("The Gentlemen")
                .releaseYear(2050)
                .director("Guy Ritchie")
                .country("USA")
                .genre("ACTION")
                .build();
        Exception exception = Assertions.assertThrows(InvalidInputException.class,
                () -> {
                    MovieInputValidator.validate(movieDto);
                });
        String expectedMessage = "Please enter correct release year";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowExceptionWhenIncorrectGenre() {
        MovieDto movieDto = MovieDto.builder()
                .title("The Gentlemen")
                .releaseYear(2019)
                .director("Guy Ritchie")
                .country("USA")
                .genre("good movie")
                .build();
        Exception exception = Assertions.assertThrows(InvalidInputException.class,
                () -> {
                    MovieInputValidator.validate(movieDto);
                });
        String expectedMessage = "Invalid genre: good movie" +
                "\n Please choose one of the genres: " + Arrays.toString(MovieGenre.values());
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}