package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.ShowRequestDto;
import com.learningProject.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.learningProject.bookmyshow.exceptions.FeaturesNotMatchedException;
import com.learningProject.bookmyshow.exceptions.MovieNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface ShowService {
    void createShow(ShowRequestDto showDetails) throws AuditoriumNotFoundException,
            MovieNotFoundException, FeaturesNotMatchedException;
}
