package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Shows extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double SilverSeatPrice;
    private Double GoldSeatPrice;
    private Double PlatinumSeatPrice;

    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
}
