package com.learningProject.bookmyshow.controller;

import com.learningProject.bookmyshow.dto.bookTicketRequestDTO;
import com.learningProject.bookmyshow.models.Ticket;
import com.learningProject.bookmyshow.service.ticketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookmyshow/ticket/")
public class TicketController {
    @Autowired
    private ticketServiceImpl ticketService;

    @PostMapping("bookTicket")
    public Ticket bookTicket(@RequestBody bookTicketRequestDTO input) throws Exception {
        Ticket ticket = ticketService.bookTicket(input.getSeatIds(), input.getUserId());
        System.out.println(ticket.toString());
        return ticket;
    }
}
