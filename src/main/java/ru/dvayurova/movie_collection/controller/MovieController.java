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

    @GetMapping
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public void createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
    }

    @PatchMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}

