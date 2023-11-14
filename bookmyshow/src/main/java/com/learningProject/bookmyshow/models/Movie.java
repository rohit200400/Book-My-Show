package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.Features;
import com.learningProject.bookmyshow.models.constants.Languages;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseModel {
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String trailer;
    private String Poster;
    private Integer rating;
    // TODO: need a variable for Duration and Interval time.

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Languages> language;
    @ManyToMany
    private List<Actor> actors;
    private LocalDate releaseDate;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Features> movieFeatures;
}
