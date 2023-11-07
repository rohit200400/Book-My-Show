package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Integer> {
}
