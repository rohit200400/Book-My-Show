package com.learningProject.bookmyshow.dto;
import com.learningProject.bookmyshow.models.constants.Features;
import java.time.LocalDateTime;
import java.util.List;
public record ShowRequestDto ( LocalDateTime startTime, LocalDateTime endTime, Double SilverSeatPrice,
                               Double GoldSeatPrice, Double PlatinumSeatPrice,
                               List<Features> showFeatures, int movieId, int auditoriumId, List<Integer> lockedSeatsId) {


}
