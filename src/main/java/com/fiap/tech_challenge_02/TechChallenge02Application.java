package com.fiap.tech_challenge_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TechChallenge02Application {

    public static void main(String[] args) {
        SpringApplication.run(TechChallenge02Application.class, args);
    }

}
