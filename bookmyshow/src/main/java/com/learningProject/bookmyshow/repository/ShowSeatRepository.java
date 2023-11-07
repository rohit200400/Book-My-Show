package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.ShowSeat;
import com.learningProject.bookmyshow.models.constants.SeatStatus;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    List<ShowSeat> findAllByIdInAndStatus(List<Integer> ids, SeatStatus status);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Modifying
    @Query("UPDATE ShowSeat ss SET ss.status = :newStatus WHERE ss.seat.id IN :seatIds")
    void updateSeatStatusBySeatIds(List<Integer> seatIds, SeatStatus newStatus);
}
