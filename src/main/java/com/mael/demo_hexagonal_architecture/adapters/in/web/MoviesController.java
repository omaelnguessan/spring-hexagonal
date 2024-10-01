package com.mael.demo_hexagonal_architecture.adapters.in.web;

import com.mael.demo_hexagonal_architecture.application.dto.CreateMovieDto;
import com.mael.demo_hexagonal_architecture.application.dto.UpdateMovieDto;
import com.mael.demo_hexagonal_architecture.application.usecases.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody CreateMovieDto movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(movie));
    }

    @PutMapping
    public ResponseEntity<?> saveMovie(@RequestBody UpdateMovieDto movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.updateMovie(movie));
    }

}
