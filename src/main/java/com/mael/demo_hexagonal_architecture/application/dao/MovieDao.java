package com.mael.demo_hexagonal_architecture.application.dao;

import com.mael.demo_hexagonal_architecture.application.dto.CreateMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.DeleteMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.UpdateMovieDto;
import com.mael.demo_hexagonal_architecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> findAllMovies();
    Optional<Movie> findMovieById(Long id);
    Optional<Movie> findMovieByTitle(String title);
    void saveMovie(CreateMovieDto createMovieDto);
    void updateMovie(UpdateMovieDto updateMovieDto);
    void deleteMovieById(Long id);
    void deleteMovie(DeleteMovieDto movie);
}
