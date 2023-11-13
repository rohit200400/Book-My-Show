package com.learningProject.bookmyshow.dto;

import com.learningProject.bookmyshow.models.constants.City;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheaterRequestDto {
    String name;
    String address;
    City city;
    List<AuditoriumRequestDto> auditoriums;
}
