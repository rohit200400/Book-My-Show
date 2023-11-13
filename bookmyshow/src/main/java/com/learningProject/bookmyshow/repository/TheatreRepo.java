package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
}
