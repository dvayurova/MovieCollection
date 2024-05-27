package ru.dvayurova.movie_collection.dto;

import lombok.Builder;

/**
 * Data Transfer Object для класса Movie
 */
@Builder
public record MovieDto (
         Long id,
         String title,
         int releaseYear,
         String director,
         String country,
         String genre
) {
}
