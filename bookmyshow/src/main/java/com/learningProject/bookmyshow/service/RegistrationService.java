package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.AuditoriumRequestDto;
import com.learningProject.bookmyshow.dto.TheaterRequestDto;
import com.learningProject.bookmyshow.exceptions.GroupNotFoundException;
import com.learningProject.bookmyshow.models.Theatre;

public interface RegistrationService {
    void registerTheatre(TheaterRequestDto theater) throws Exception;

    void deregisterTheatre(Integer theaterId) throws GroupNotFoundException;

    Theatre addAuditorium(Integer theaterId, AuditoriumRequestDto audi) throws GroupNotFoundException;
}
