package com.learningProject.bookmyshow;

import com.learningProject.bookmyshow.controller.TicketController;
import com.learningProject.bookmyshow.models.User;
import com.learningProject.bookmyshow.repository.ShowRepository;
import com.learningProject.bookmyshow.repository.ShowSeatRepository;
import com.learningProject.bookmyshow.service.IticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShowApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

}
