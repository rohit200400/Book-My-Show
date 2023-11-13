package com.learningProject.bookmyshow.controller;

import com.learningProject.bookmyshow.dto.AuditoriumRequestDto;
import com.learningProject.bookmyshow.dto.TheaterRequestDto;
import com.learningProject.bookmyshow.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addTheatre")
    public ResponseEntity registerTheatre(@RequestBody TheaterRequestDto theater) throws Exception {
        registrationService.registerTheatre(theater);
        return ResponseEntity.ok("Theatre registered.");
    }

    @DeleteMapping("/deleteTheatre/{theaterId}")
    public ResponseEntity deregisterTheatre(@PathVariable("theaterId") Integer theaterId) throws Exception {
        registrationService.deregisterTheatre(theaterId);
        return ResponseEntity.ok("Removed theatre.");
    }

    @PostMapping("/addAuditorium/{theaterId}")
    public ResponseEntity addAuditorium(@RequestBody AuditoriumRequestDto audi, @PathVariable("theaterId") Integer theaterId) throws Exception {
        registrationService.addAuditorium(theaterId, audi);
        return ResponseEntity.ok("Auditorium added to theatre.");
    }
}
