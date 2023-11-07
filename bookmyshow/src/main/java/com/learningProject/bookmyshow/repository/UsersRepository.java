package com.learningProject.bookmyshow.repository;

import com.learningProject.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
