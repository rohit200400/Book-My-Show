package com.learningProject.bookmyshow.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class bookTicketRequestDTO {
    List<Integer> seatIds;
    Integer userId;
}
