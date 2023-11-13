package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepo extends JpaRepository<Auditorium, Integer> {
}
