package com.learningProject.bookmyshow;

import com.learningProject.bookmyshow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
    @Autowired
    private InitService initService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner from commandLine");
        //initService.initialise();
        System.out.println("Runner from commandLine finished");
    }

}
