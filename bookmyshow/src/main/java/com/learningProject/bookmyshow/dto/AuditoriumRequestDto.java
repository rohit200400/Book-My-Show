package com.learningProject.bookmyshow.dto;

import com.learningProject.bookmyshow.models.constants.Features;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequestDto {
    List<Features> auditoriumFeatures;
    int goldSeatCount;
    int silverSeatCount;
    int platinumSeatCount;
}
