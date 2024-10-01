package com.mael.demo_hexagonal_architecture.adapters.out.postgresJDBC;

import com.mael.demo_hexagonal_architecture.adapters.out.postgresJDBC.entities.MovieEntity;
import com.mael.demo_hexagonal_architecture.adapters.out.postgresJDBC.repositories.MovieRepository;
import com.mael.demo_hexagonal_architecture.application.dao.MovieDao;
import com.mael.demo_hexagonal_architecture.application.dto.CreateMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.DeleteMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.UpdateMovieDto;
import com.mael.demo_hexagonal_architecture.domain.Movie;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MoviesDaoAdapter implements MovieDao {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) movieRepository.findAll())
                .stream()
                .map(movieEntity ->
                     new Movie(
                            movieEntity.id(),
                            movieEntity.title(),
                            movieEntity.description(),
                            movieEntity.releaseDate(),
                            movieEntity.directorName()
                    )).toList();
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return movieRepository.findMoviesByTitle(title);
    }

    @Override
    public void saveMovie(CreateMovieDto createMovieDto) {
        movieRepository.save(new MovieEntity(
                null,
                createMovieDto.title(),
                createMovieDto.description(),
                createMovieDto.releaseDate(),
                createMovieDto.directorName(),
                null
        ));

    }

    @Override
    public void updateMovie(UpdateMovieDto updateMovieDto) {
        movieRepository.save(new MovieEntity(
                updateMovieDto.id(),
                updateMovieDto.title(),
                updateMovieDto.description(),
                updateMovieDto.releaseDate(),
                updateMovieDto.directorName(),
                null
        ));

    }

    @Override
    public void deleteMovieById(Long id) {

    }

    @Override
    public void deleteMovie(DeleteMovieDto deleteMovieDto) {
        movieRepository.delete(new MovieEntity(
                deleteMovieDto.id(),
                deleteMovieDto.title(),
                deleteMovieDto.description(),
                deleteMovieDto.releaseDate(),
                deleteMovieDto.directorName(),
                null
        ));
    }
}
