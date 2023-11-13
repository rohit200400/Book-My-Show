package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Features> auditoriumFeatures;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;
}
