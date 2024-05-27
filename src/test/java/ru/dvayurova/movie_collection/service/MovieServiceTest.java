package ru.dvayurova.movie_collection.service;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dvayurova.movie_collection.dto.MovieDto;
import ru.dvayurova.movie_collection.dto.MovieDtoMapper;
import ru.dvayurova.movie_collection.genres.MovieGenre;
import ru.dvayurova.movie_collection.model.Movie;
import ru.dvayurova.movie_collection.repository.MovieRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieDtoMapper movieDtoMapper;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void testGetMovieById() {
        Movie movie = new Movie(1L, "Test Title", 2021, "Director", "Country", MovieGenre.COMEDY);
        MovieDto movieDto = new MovieDto(1L, "Test Title", 2021, "Director", "Country", "COMEDY");
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        when(movieDtoMapper.apply(movie)).thenReturn(movieDto);
        MovieDto result = movieService.getMovieById(1L);
        assertEquals(movieDto, result);
    }
}