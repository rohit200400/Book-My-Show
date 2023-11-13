package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Shows extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double SilverSeatPrice;
    private Double GoldSeatPrice;
    private Double PlatinumSeatPrice;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Features> showFeatures;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
}
