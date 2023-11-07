package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.exceptions.SeatAlreadyBookedException;
import com.learningProject.bookmyshow.exceptions.UserNotFoundException;
import com.learningProject.bookmyshow.models.ShowSeat;
import com.learningProject.bookmyshow.models.Ticket;
import com.learningProject.bookmyshow.models.User;
import com.learningProject.bookmyshow.models.constants.SeatStatus;
import com.learningProject.bookmyshow.repository.ShowRepository;
import com.learningProject.bookmyshow.repository.ShowSeatRepository;
import com.learningProject.bookmyshow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IticketService implements ticketService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIDs, Integer userId) throws UserNotFoundException, SeatAlreadyBookedException {
        // Getting all the seats and validating its availability
        List<ShowSeat> selectedSeats = showSeatRepository.findAllByIdInAndStatus(showSeatIDs, SeatStatus.AVAILABLE);
        if (showSeatIDs.size() != selectedSeats.size()) {
            throw new SeatAlreadyBookedException("Few or all of your selected seats are Booked or currently Locked for booking.");
        }
        // Getting User
        Optional<User> user = usersRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("There is no User in the database with corresponding UserID.");
        }
        // Locking the seats
        showSeatRepository.updateSeatStatusBySeatIds(showSeatIDs, SeatStatus.LOCKED);

        //generating ticket
        Ticket ticket = new Ticket(selectedSeats, selectedSeats.get(0).getShow(), user.get());
        return ticket;
    }
}
