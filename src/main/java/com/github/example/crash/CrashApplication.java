package com.github.example.crash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrashApplication implements CommandLineRunner {

    @Autowired
    private MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(CrashApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.messageService.startJobs();
    }
}
