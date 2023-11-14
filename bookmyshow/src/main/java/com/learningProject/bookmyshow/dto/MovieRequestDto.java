package com.learningProject.bookmyshow.dto;

import com.learningProject.bookmyshow.models.Actor;
import com.learningProject.bookmyshow.models.constants.Features;
import com.learningProject.bookmyshow.models.constants.Languages;

import java.time.LocalDate;
import java.util.List;

public record MovieRequestDto(String name, String description, String trailer, String Poster,
                              Integer rating, List<Languages> language,List<Actor> actors,
                              LocalDate releaseDate, List<Features> movieFeatures) {
}
