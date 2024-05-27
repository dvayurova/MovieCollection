package ru.dvayurova.movie_collection.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dvayurova.movie_collection.dto.MovieDto;
import ru.dvayurova.movie_collection.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * Вовзращает список всех фильмов
     */
    @GetMapping
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Возвращает фильм по его ID.
     *
     * @param id идентификатор фильма.
     * @return DTO фильма.
     */
    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    /**
     * Создает новый фильм.
     *
     * @param movieDto DTO фильма.
     */
    @PostMapping
    public void createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
    }
    /**
     * Обновляет существующий фильм.
     *
     * @param id       идентификатор фильма.
     * @param movieDto обновленные данные фильма.
     */
    @PatchMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        movieService.updateMovie(id, movieDto);
    }

    /**
     * Удаляет фильм по его ID.
     *
     * @param id идентификатор фильма.
     */
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}

