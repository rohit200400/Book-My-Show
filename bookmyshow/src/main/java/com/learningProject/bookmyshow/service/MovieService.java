package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.MovieRequestDto;
import com.learningProject.bookmyshow.models.Movie;
import org.springframework.web.bind.annotation.RequestBody;

public interface MovieService {
    Movie addMovie(MovieRequestDto movie);
}