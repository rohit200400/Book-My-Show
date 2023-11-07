package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.SeatType;
import com.learningProject.bookmyshow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    private LocalDateTime timeOfBooking;
    private double totalAmount;
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Shows show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    public Ticket(List<ShowSeat> showSeats, Shows show, User user) {
        this.timeOfBooking = LocalDateTime.now();
        this.showSeats = showSeats;
        this.show = show;
        this.totalAmount = showSeats.size() * getTicketPrice(show, showSeats.get(0).getSeat().getType());
        this.ticketStatus = TicketStatus.IN_PROGRESS;
        this.user = user;
    }

    private double getTicketPrice(Shows show, SeatType type) {
        switch (type) {
            case SILVER -> {
                return show.getSilverSeatPrice();
            }
            case GOLD -> {
                return show.getGoldSeatPrice();
            }
            case PLATINUM -> {
                return show.getPlatinumSeatPrice();
            }
        }
        return 0;
    }
}
