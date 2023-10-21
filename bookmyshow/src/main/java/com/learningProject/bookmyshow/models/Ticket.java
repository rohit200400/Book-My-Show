package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.TicketStatus;
import jakarta.persistence.*;
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
}
