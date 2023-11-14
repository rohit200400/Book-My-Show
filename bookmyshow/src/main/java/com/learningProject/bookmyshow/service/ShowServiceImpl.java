package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.dto.ShowRequestDto;
import com.learningProject.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.learningProject.bookmyshow.exceptions.FeaturesNotMatchedException;
import com.learningProject.bookmyshow.exceptions.MovieNotFoundException;
import com.learningProject.bookmyshow.exceptions.TheatreNotFoundException;
import com.learningProject.bookmyshow.models.*;
import com.learningProject.bookmyshow.models.constants.Features;
import com.learningProject.bookmyshow.models.constants.SeatStatus;
import com.learningProject.bookmyshow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ShowServiceImpl implements ShowService{
    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private AuditoriumRepo auditoriumRepo;
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    @Transactional
    public void createShow(ShowRequestDto showDetails) throws AuditoriumNotFoundException, MovieNotFoundException, FeaturesNotMatchedException {
        Optional<Auditorium> auditorium = auditoriumRepo.findById(showDetails.auditoriumId());
        if (auditorium.isEmpty()) {
            throw new AuditoriumNotFoundException("Auditorium not found.");
        }
        Optional<Movie> movie = movieRepo.findById(showDetails.movieId());
        if (movie.isEmpty()) {
            throw new MovieNotFoundException("Movie not found.");
        }
        for (Features showFeature: showDetails.showFeatures()
             ) {
            if (!movie.get().getMovieFeatures().contains(showFeature) ||
                    !auditorium.get().getAuditoriumFeatures().contains(showFeature)) {
                        throw new FeaturesNotMatchedException("Features stated in the show is not supported " +
                                "by the movie or the auditorium.");
                    }
        }
        // todo : add validation for any other corresponding show in the same auditorium

        Shows show = new Shows();
        show.setAuditorium(auditorium.get());
        show.setShowFeatures(showDetails.showFeatures());
        show.setMovie(movie.get());
        show.setStartTime(showDetails.startTime());
        show.setEndTime(showDetails.endTime());
        show.setGoldSeatPrice(showDetails.GoldSeatPrice());
        show.setPlatinumSeatPrice(showDetails.PlatinumSeatPrice());
        show.setSilverSeatPrice(showDetails.SilverSeatPrice());
        show = showRepository.save(show);

        Optional<List<Seat>> audiSeat = seatRepo.findAllByAuditoriumId(auditorium.get().getId());
        for (Seat seat : audiSeat.get()) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(show);
            if(showDetails.lockedSeatsId().contains(seat.getId())){
                showSeat.setStatus(SeatStatus.LOCKED);
            }else{
                showSeat.setStatus(SeatStatus.AVAILABLE);
            }
            showSeatRepository.save(showSeat);
        }
    }


}
