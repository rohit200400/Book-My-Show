package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.AuditoriumRequestDto;
import com.learningProject.bookmyshow.dto.TheaterRequestDto;
import com.learningProject.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.learningProject.bookmyshow.exceptions.TheatreNotFoundException;
import com.learningProject.bookmyshow.models.Theatre;

public interface RegistrationService {
    void registerTheatre(TheaterRequestDto theater) throws Exception;

    void deregisterTheatre(Integer theaterId) throws TheatreNotFoundException;

    Theatre addAuditorium(Integer theaterId, AuditoriumRequestDto audi)
            throws TheatreNotFoundException;

    void removeAuditorium(Integer theaterId, Integer auditoriumId)
            throws TheatreNotFoundException, AuditoriumNotFoundException;
}
