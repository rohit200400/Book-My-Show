package com.learningProject.bookmyshow.controller;

import com.learningProject.bookmyshow.dto.ShowRequestDto;
import com.learningProject.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.learningProject.bookmyshow.exceptions.FeaturesNotMatchedException;
import com.learningProject.bookmyshow.exceptions.MovieNotFoundException;
import com.learningProject.bookmyshow.models.Shows;
import com.learningProject.bookmyshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/createShow")
    public ResponseEntity createShow(@RequestBody ShowRequestDto showDetails)
            throws FeaturesNotMatchedException, MovieNotFoundException, AuditoriumNotFoundException {
        showService.createShow(showDetails);
        return ResponseEntity.ok("Show created.");
    }
    // todo : get the auditoriums list from the theatres, get the movie list sorted by release date
}
