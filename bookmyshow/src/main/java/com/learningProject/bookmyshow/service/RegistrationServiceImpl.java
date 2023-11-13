package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.AuditoriumRequestDto;
import com.learningProject.bookmyshow.dto.TheaterRequestDto;
import com.learningProject.bookmyshow.exceptions.GroupNotFoundException;
import com.learningProject.bookmyshow.models.Auditorium;
import com.learningProject.bookmyshow.models.Seat;
import com.learningProject.bookmyshow.models.Theatre;
import com.learningProject.bookmyshow.models.constants.SeatStatus;
import com.learningProject.bookmyshow.models.constants.SeatType;
import com.learningProject.bookmyshow.repository.AuditoriumRepo;
import com.learningProject.bookmyshow.repository.SeatRepo;
import com.learningProject.bookmyshow.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private AuditoriumRepo auditoriumRepo;
    @Autowired
    private SeatRepo seatRepo;

    @Override
    @Transactional
    public void registerTheatre(TheaterRequestDto theater) throws Exception {
        Theatre newTheatre = new Theatre(theater.getName(), theater.getAddress(), theater.getCity(), null);
        newTheatre = theatreRepo.save(newTheatre);
        List<Auditorium> allAudis = new ArrayList<>();
        for (int i = 0; i < theater.getAuditoriums().size(); i++) {
            Auditorium audi = new Auditorium();
            audi.setName("Auditorium" + (i + 1));
            audi.setAuditoriumFeatures(theater.getAuditoriums().get(i).getAuditoriumFeatures());
            audi.setTheatre(newTheatre);
            audi = auditoriumRepo.save(audi);
            List<Seat> audiSeats = new ArrayList<>();
            for (int j = 0; j < theater.getAuditoriums().get(i).getSilverSeatCount(); j++) {
                Seat seat = new Seat();
                seat.setSeatNumber(audi.getName() + "-S" + (j + 1));
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setAuditorium(audi);
                seat.setType(SeatType.SILVER);
                seat = seatRepo.save(seat);
                audiSeats.add(seat);
            }
            for (int j = 0; j < theater.getAuditoriums().get(i).getGoldSeatCount(); j++) {
                Seat seat = new Seat();
                seat.setSeatNumber(audi.getName() + "-G" + (j + 1));
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setAuditorium(audi);
                seat.setType(SeatType.GOLD);
                seat = seatRepo.save(seat);
                audiSeats.add(seat);
            }
            for (int j = 0; j < theater.getAuditoriums().get(i).getPlatinumSeatCount(); j++) {
                Seat seat = new Seat();
                seat.setSeatNumber(audi.getName() + "-P" + (j + 1));
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setAuditorium(audi);
                seat.setType(SeatType.PLATINUM);
                seat = seatRepo.save(seat);
                audiSeats.add(seat);
            }
            audi.setSeats(audiSeats);
            audi = auditoriumRepo.save(audi);
            allAudis.add(audi);
        }
        newTheatre.setAuditoriums(allAudis);
        newTheatre = theatreRepo.save(newTheatre);
    }

    @Override
    public void deregisterTheatre(Integer theaterId) throws GroupNotFoundException {
        Optional<Theatre> theatre = theatreRepo.findById(theaterId);
        if (theatre.isEmpty()) {
            throw new GroupNotFoundException("The group ID sent is not valid.");
        }
        theatreRepo.deleteById(theaterId);
    }

    @Override
    public Theatre addAuditorium(Integer theaterId, AuditoriumRequestDto auditorium) throws GroupNotFoundException {
        Optional<Theatre> theatre = theatreRepo.findById(theaterId);
        if (theatre.isEmpty()) {
            throw new GroupNotFoundException("The group ID sent is not valid.");
        }
        List<Auditorium> auditoriums = theatre.get().getAuditoriums();
        Auditorium audi = new Auditorium();
        audi.setName("Auditorium" + (auditoriums.size() + 1));
        audi.setAuditoriumFeatures(auditorium.getAuditoriumFeatures());
        audi.setTheatre(theatre.get());
        audi = auditoriumRepo.save(audi);
        List<Seat> audiSeats = new ArrayList<>();
        for (int j = 0; j < auditorium.getSilverSeatCount(); j++) {
            Seat seat = new Seat();
            seat.setSeatNumber(audi.getName() + "-S" + (j + 1));
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setAuditorium(audi);
            seat.setType(SeatType.SILVER);
            seat = seatRepo.save(seat);
            audiSeats.add(seat);
        }
        for (int j = 0; j < auditorium.getGoldSeatCount(); j++) {
            Seat seat = new Seat();
            seat.setSeatNumber(audi.getName() + "-G" + (j + 1));
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setAuditorium(audi);
            seat.setType(SeatType.GOLD);
            seat = seatRepo.save(seat);
            audiSeats.add(seat);
        }
        for (int j = 0; j < auditorium.getPlatinumSeatCount(); j++) {
            Seat seat = new Seat();
            seat.setSeatNumber(audi.getName() + "-P" + (j + 1));
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setAuditorium(audi);
            seat.setType(SeatType.PLATINUM);
            seat = seatRepo.save(seat);
            audiSeats.add(seat);
        }
        audi.setSeats(audiSeats);
        audi = auditoriumRepo.save(audi);
        auditoriums.add(audi);

        theatre.get().setAuditoriums(auditoriums);
        return theatreRepo.save(theatre.get());

    }
}
