package ru.dvayurova.movie_collection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Optional<Movie> findMovieById(Long id){
        return repository.findById(id);
    }
}
