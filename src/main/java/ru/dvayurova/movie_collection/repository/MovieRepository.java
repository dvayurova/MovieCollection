package ru.dvayurova.movie_collection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dvayurova.movie_collection.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
