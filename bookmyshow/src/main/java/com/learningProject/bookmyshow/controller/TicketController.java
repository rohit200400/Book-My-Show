package com.learningProject.bookmyshow.controller;

import com.learningProject.bookmyshow.dto.bookTicketRequestDTO;
import com.learningProject.bookmyshow.models.Ticket;
import com.learningProject.bookmyshow.models.User;
import com.learningProject.bookmyshow.service.IticketService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookmyshow/ticket/")
public class TicketController {
    @Autowired
    private IticketService ticketService;

    @PostMapping("bookTicket")
    public Ticket bookTicket(@NotNull bookTicketRequestDTO input) throws Exception {
        Ticket ticket = ticketService.bookTicket(input.getSeatIds(), input.getUserId());
        System.out.println(ticket.toString());
        return ticket;
    }
}
