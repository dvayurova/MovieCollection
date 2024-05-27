package ru.dvayurova.movie_collection.dto;


import org.springframework.stereotype.Service;
import ru.dvayurova.movie_collection.model.Movie;

import java.util.function.Function;

@Service
public class MovieDtoMapper implements Function<Movie, MovieDto> {

    @Override
    public MovieDto apply(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .country(movie.getCountry())
                .genre(movie.getGenre().toString())
                .build();
    }
}
