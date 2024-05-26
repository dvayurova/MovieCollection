package ru.dvayurova.movie_collection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dvayurova.movie_collection.exception.MovieNotFoundException;
import ru.dvayurova.movie_collection.model.Movie;
import ru.dvayurova.movie_collection.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

    public Optional<Movie> getMovieById(Long id){
        return repository.findById(id);
    }

    public Movie createMovie(Movie movie){
        return repository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieUpdates){
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id %d wasn't found", id)));
        movie.setGenre(movieUpdates.getGenre());
        movie.setTitle(movieUpdates.getTitle());
        movie.setReleaseYear(movieUpdates.getReleaseYear());
        movie.setDirector(movieUpdates.getDirector());
        movie.setCountry(movieUpdates.getCountry());
        return repository.save(movie);
    }

    public void deleteMovie(Long id){
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id %d wasn't found", id)));
        repository.delete(movie);
    }
}
