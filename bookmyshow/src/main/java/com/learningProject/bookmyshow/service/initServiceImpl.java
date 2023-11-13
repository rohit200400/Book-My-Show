package com.learningProject.bookmyshow.service;

import com.learningProject.bookmyshow.models.*;
import com.learningProject.bookmyshow.models.constants.*;
import com.learningProject.bookmyshow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class initServiceImpl implements InitService {
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private AuditoriumRepo auditoriumRepo;
    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private ActorRepo actorRepo;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ShowRepository showRepository;


    @Override
    public void initialise() {

        // setting Actors
        List<Actor> cast = List.of(new Actor("Nicolas Cage"), new Actor("Eva Mendes"),
                new Actor("Sam Elliott"), new Actor("Matt Long"));
        for (Actor actor : cast) {
            actor = actorRepo.save(actor);
        }

        // setting Languages
        List<Languages> availableLanguages = List.of(Languages.ENGLISH, Languages.HINDI);

        // setting movie features
        List<Features> movieFeatures = List.of(Features.THREE_DIMENSIONAL, Features.DOLLBY, Features.IMAX);

        // setting movies
        Movie ghostRider = Movie.builder()
                .name("Ghost Rider")
                .rating(7)
                .Poster("https://upload.wikimedia.org/wikipedia/en/7/71/GhostRiderBigPoster.jpg")
                .trailer("https://youtu.be/nu6R7ypaz5g")
                .description("Ghost Rider is a 2007 American superhero film written and directed by Mark Steven Johnson. Based on the Marvel Comics character of the same name, it was produced by Columbia Pictures in association with Marvel Entertainment, Crystal Sky Pictures, and Relativity Media, and distributed by Sony Pictures Releasing. The film stars Nicolas Cage as the titular character, with Eva Mendes, Wes Bentley, Sam Elliott, Donal Logue, Matt Long, and Peter Fonda in supporting roles. Johnny Blaze, a motorcycle stuntman sells his soul and becomes a bounty hunter of evil demons: the Ghost Rider.")
                .releaseDate(LocalDate.of(2007, 02, 16))
                .actors(cast)
                .language(availableLanguages)
                .movieFeatures(movieFeatures)
                .build();
        Movie savedMovie = movieRepo.save(ghostRider);

        // Adding Theaters
        List<String> THEATRE_NAMES = List.of(
                "Galaxy Cinemas",
                "Starlight Theatres",
                "Metroplex Movies",
                "Royal Pavilion Cinemas",
                "Silver Screen Multiplex",
                "Majestic Cinemahouse",
                "Dreamland Theatres",
                "Vista View Cinemas",
                "Crystal Palace Movies",
                "Elite Encore Theatres"
        );

        for (String theatreName : THEATRE_NAMES
        ) {
            Theatre newTheatre = new Theatre(theatreName, "123, street xyz", getRandomCity(), null);
            newTheatre = theatreRepo.save(newTheatre);
            List<Auditorium> allAudis = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Auditorium audi = new Auditorium();
                audi.setName(theatreName + "audi" + (i + 1));
                audi.setAuditoriumFeatures(List.of(Features.THREE_DIMENSIONAL, Features.DOLLBY, Features.IMAX));
                audi.setTheatre(newTheatre);
                audi = auditoriumRepo.save(audi);
                List<Seat> audiSeats = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    Seat seat = new Seat();
                    seat.setSeatNumber(audi.getName() + j);
                    seat.setStatus(SeatStatus.AVAILABLE);
                    seat.setAuditorium(audi);
                    if (j < 5) {
                        seat.setType(SeatType.GOLD);
                    } else if (j < 10) {
                        seat.setType(SeatType.PLATINUM);
                    } else {
                        seat.setType(SeatType.SILVER);
                    }
                    seat = seatRepo.save(seat);
                    audiSeats.add(seat);
                }
                audi.setSeats(audiSeats);
                audi = auditoriumRepo.save(audi);
                allAudis.add(audi);
            }
            newTheatre.setAuditoriums(allAudis);
            newTheatre = theatreRepo.save(newTheatre);


            // Adding a show
            Shows show = new Shows();
            show.setAuditorium(allAudis.get(1));
            show.setShowFeatures(List.of(Features.THREE_DIMENSIONAL, Features.DOLLBY, Features.IMAX));
            show.setMovie(savedMovie);
            show.setStartTime(LocalDateTime.of(2023, 9, 23, 15, 00, 00));
            show.setEndTime(LocalDateTime.of(2023, 9, 23, 15, 00, 00));
            show.setGoldSeatPrice(200.00);
            show.setPlatinumSeatPrice(300.00);
            show.setSilverSeatPrice(100.00);
            show = showRepository.save(show);

            Optional<List<Seat>> audiSeat = seatRepo.findAllByAuditoriumId(allAudis.get(1).getId());
            for (Seat seat : audiSeat.get()) {
                ShowSeat showSeat = new ShowSeat();
                showSeat.setSeat(seat);
                showSeat.setShow(show);
                if (seat.getId() % 3 == 0) {
                    showSeat.setStatus(SeatStatus.LOCKED);
                } else {
                    showSeat.setStatus(SeatStatus.AVAILABLE);
                }
                showSeatRepository.save(showSeat);
            }
        }


    }

    private City getRandomCity() {
        City[] cities = City.values();
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }
}
