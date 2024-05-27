package ru.dvayurova.movie_collection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dvayurova.movie_collection.dto.MovieDto;
import ru.dvayurova.movie_collection.dto.MovieDtoMapper;
import ru.dvayurova.movie_collection.exception.MovieNotFoundException;
import ru.dvayurova.movie_collection.model.Movie;
import ru.dvayurova.movie_collection.repository.MovieRepository;
import ru.dvayurova.movie_collection.validator.MovieInputValidator;

import java.util.List;

/**
 * Сервис для выполнения операций над фильмами.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private MovieDtoMapper movieDtoMapper;

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    /**
     * Получает список всех фильмов
     */
    public List<MovieDto> getAllMovies() {
        logger.debug("Getting all movies");
        return repository.findAll()
                .stream()
                .map(movieDtoMapper)
                .toList();
    }

    /**
     * Получает фильм по его ID.
     *
     * @param id идентификатор фильма.
     * @return DTO фильма.
     * @throws MovieNotFoundException если фильм с данным ID не найден.
     */
    public MovieDto getMovieById(Long id) {
        logger.debug("Getting a movie by id: {}", id);
        return repository.findById(id)
                .map(movieDtoMapper)
                .orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id %d wasn't found", id)));
    }

    /**
     * Создает новый фильм.
     *
     * @param movieDto DTO фильма.
     */
    public void createMovie(MovieDto movieDto) {
        Movie movie = MovieInputValidator.validate(movieDto);
        logger.debug("Creating new movie: {}", movie);
        repository.save(movie);
    }

    /**
     * Обновляет существующий фильм.
     *
     * @param id       идентификатор фильма.
     * @param movieDto обновленные данные фильма.
     * @throws MovieNotFoundException если фильм с данным ID не найден.
     */
    public void updateMovie(Long id, MovieDto movieDto) {
        Movie movieUpdates = MovieInputValidator.validate(movieDto);
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id %d wasn't found", id)));
        movie.setTitle(movieUpdates.getTitle());
        movie.setReleaseYear(movieUpdates.getReleaseYear());
        movie.setDirector(movieUpdates.getDirector());
        movie.setCountry(movieUpdates.getCountry());
        movie.setGenre(movieUpdates.getGenre());
        logger.debug("Updating a movie with id: {}", id);
        repository.save(movie);
    }

    /**
     * Удаляет фильм по его ID.
     *
     * @param id идентификатор фильма.
     * @throws MovieNotFoundException если фильм с данным ID не найден.
     */
    public void deleteMovie(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id %d wasn't found", id)));
        logger.debug("Deleting a movie with id: {}", id);
        repository.delete(movie);
    }
}
