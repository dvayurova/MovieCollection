package ru.dvayurova.movie_collection.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dvayurova.movie_collection.genres.MovieGenre;

/**
 * Класс сущности Movie для сохранения в БД
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name="release_year")
    private int releaseYear;
    private String director;
    private String country;
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;
}
