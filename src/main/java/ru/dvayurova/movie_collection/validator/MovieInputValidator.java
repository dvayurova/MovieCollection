package ru.dvayurova.movie_collection.validator;

import org.springframework.stereotype.Component;
import ru.dvayurova.movie_collection.model.Movie;

import java.time.LocalDate;

@Component
public class MovieInputValidator {

    private static final int FIRST_MOVIE_RELEASE_YEAR = 1895;
    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    public static boolean isValidInput(Movie movie){
        return isValidTitle(movie.getTitle()) && isValidReleaseYear(movie.getReleaseYear());

    }

    private static boolean isValidTitle(String title){
        return title != null;
    }

    private static boolean isValidReleaseYear(int releaseYear){
        return releaseYear >= FIRST_MOVIE_RELEASE_YEAR && releaseYear <= CURRENT_YEAR;
    }


}
