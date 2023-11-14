package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.MovieRequestDto;
import com.learningProject.bookmyshow.models.Actor;
import com.learningProject.bookmyshow.models.Movie;
import com.learningProject.bookmyshow.models.constants.Features;
import com.learningProject.bookmyshow.models.constants.Languages;
import com.learningProject.bookmyshow.repository.ActorRepo;
import com.learningProject.bookmyshow.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private ActorRepo actorRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public Movie addMovie(MovieRequestDto movie) {
        // setting Actors
        List<Actor> cast = movie.actors();
        for (Actor actor : cast) {
            actor = actorRepo.save(actor);
        }

        // setting movies
        Movie newMovie = Movie.builder()
                .name(movie.name())
                .rating(movie.rating())
                .Poster(movie.Poster())
                .trailer(movie.trailer())
                .description(movie.description())
                .releaseDate(movie.releaseDate())
                .actors(cast)
                .language(movie.language())
                .movieFeatures(movie.movieFeatures())
                .build();
        Movie savedMovie = movieRepo.save(newMovie);
        return savedMovie;
    }
}
