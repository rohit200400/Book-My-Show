package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepo extends JpaRepository<Ticket, Integer> {
}
