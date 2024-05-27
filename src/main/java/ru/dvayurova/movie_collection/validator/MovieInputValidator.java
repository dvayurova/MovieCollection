package ru.dvayurova.movie_collection.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.dvayurova.movie_collection.dto.MovieDto;
import ru.dvayurova.movie_collection.exception.InvalidInputException;
import ru.dvayurova.movie_collection.genres.MovieGenre;
import ru.dvayurova.movie_collection.model.Movie;
import ru.dvayurova.movie_collection.service.MovieService;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class MovieInputValidator {

    private static final int FIRST_MOVIE_RELEASE_YEAR = 1895;
    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public static Movie validate(MovieDto movieDto) {
        if (!isValidTitle(movieDto.title())) {
            logger.error("Title cannot be empty");
            throw new InvalidInputException("Please enter title");
        }
        if (!isValidReleaseYear(movieDto.releaseYear())){
            logger.error(String.format("Release year should be between %d and %d",
                    FIRST_MOVIE_RELEASE_YEAR, CURRENT_YEAR));
            throw new InvalidInputException("Please enter correct release year");
        }
        return Movie.builder()
                .title(movieDto.title())
                .releaseYear(movieDto.releaseYear())
                .director(movieDto.director())
                .country(movieDto.country())
                .genre(validateGenre(movieDto.genre()))
                .build();
    }

    private static boolean isValidTitle(String title) {
        return title != null;
    }

    private static boolean isValidReleaseYear(int releaseYear) {
        return releaseYear >= FIRST_MOVIE_RELEASE_YEAR && releaseYear <= CURRENT_YEAR;
    }

    public static MovieGenre validateGenre(String genre) throws InvalidInputException {
        try {
            return MovieGenre.valueOf(genre.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Invalid genre");
            throw new InvalidInputException("Invalid genre: " + genre +
                    "\n Please choose one of the genres: " + Arrays.toString(MovieGenre.values()));
        }
    }

}
