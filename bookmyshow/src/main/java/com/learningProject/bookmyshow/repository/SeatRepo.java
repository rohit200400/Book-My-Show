package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
    Optional<List<Seat>> findAllByAuditoriumId(Integer auditoriumId);
}
