package com.mael.demo_hexagonal_architecture.adapters.out.postgresJDBC.repositories;

import com.mael.demo_hexagonal_architecture.adapters.out.postgresJDBC.entities.MovieEntity;
import com.mael.demo_hexagonal_architecture.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    @Query("SELECT * FROM movies WHERE title =:title")
    Optional<Movie> findMoviesByTitle(@Param("title") String title);
}
