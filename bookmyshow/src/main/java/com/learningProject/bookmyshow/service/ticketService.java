package com.learningProject.bookmyshow.service;


import com.learningProject.bookmyshow.exceptions.SeatAlreadyBookedException;
import com.learningProject.bookmyshow.exceptions.UserNotFoundException;
import com.learningProject.bookmyshow.models.ShowSeat;
import com.learningProject.bookmyshow.models.Ticket;
import com.learningProject.bookmyshow.models.User;

import java.util.List;

public interface ticketService {
    Ticket bookTicket(List<Integer> showSeatIds, Integer userId) throws SeatAlreadyBookedException, UserNotFoundException;
}
