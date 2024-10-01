package com.mael.demo_hexagonal_architecture.application.usecases;

import com.mael.demo_hexagonal_architecture.application.dao.MovieDao;
import com.mael.demo_hexagonal_architecture.application.dto.CreateMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.DeleteMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.UpdateMovieDto;
import com.mael.demo_hexagonal_architecture.domain.Movie;
import com.mael.demo_hexagonal_architecture.infrastructure.exceptions.MovieAlreadyExistsException;
import com.mael.demo_hexagonal_architecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCase {

    private final MovieDao movieDao;


    public String saveMovie(CreateMovieDto createMovieDto) {
        //TODO: validate movie dto

        var isPresent = movieDao.findMovieByTitle(createMovieDto.title()).isPresent();

        if (isPresent) {
            throw new MovieAlreadyExistsException("Movie already exists");
        }

        this.movieDao.saveMovie(createMovieDto);

        return "Movie saved successfully";
    }

    public List<Movie> getAllMovies() {
        return movieDao.findAllMovies();
    }

    public Movie getMovieByTitle(String movieTitle) {
        return movieDao.findMovieByTitle(movieTitle).orElseThrow(
                () -> new MovieNotFoundException("This movie does not exist")
        );
    }

    public String updateMovie(UpdateMovieDto updateMovieDto) {

        var isPresent = movieDao.findMovieByTitle(updateMovieDto.title()).isPresent();
        if (!isPresent) {
            throw new MovieNotFoundException("This movie does not exist");
        }

        movieDao.updateMovie(updateMovieDto);

        return "Movie updated successfully";
    }

    public String deleteMovieById(Long movieId) {

        var isPresent = movieDao.findMovieById(movieId).isPresent();
        if (!isPresent) {
            throw new MovieNotFoundException("This movie does not exist");
        }

        movieDao.deleteMovieById(movieId);
        return "Movie deleted successfully";
    }

    public String deleteMovie(DeleteMovieDto movie) {

        var isPresent = movieDao.findMovieById(movie.id()).isPresent();
        if (!isPresent) {
            throw new MovieNotFoundException("This movie does not exist");
        }

        movieDao.deleteMovie(movie);
        return "Movie deleted successfully";
    }
}
