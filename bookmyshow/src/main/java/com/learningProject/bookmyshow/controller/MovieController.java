package com.learningProject.bookmyshow.controller;

import com.learningProject.bookmyshow.dto.MovieRequestDto;
import com.learningProject.bookmyshow.models.Movie;
import com.learningProject.bookmyshow.repository.MovieRepo;
import com.learningProject.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/add")
    public Movie addMovie(@RequestBody MovieRequestDto movie){
        return movieService.addMovie(movie);
    }
}
