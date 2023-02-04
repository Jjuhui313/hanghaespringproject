package com.sparta.hanghaespringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaespringprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaespringprojectApplication.class, args);
    }

}
