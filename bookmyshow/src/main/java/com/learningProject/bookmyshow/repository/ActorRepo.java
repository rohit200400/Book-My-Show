package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {
}
