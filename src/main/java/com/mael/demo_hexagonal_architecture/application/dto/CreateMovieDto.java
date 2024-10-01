package com.mael.demo_hexagonal_architecture.application.dto;

import java.time.LocalDate;

public record CreateMovieDto(
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {
}
