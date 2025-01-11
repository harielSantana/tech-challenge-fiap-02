package com.fiap.tech_challenge_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fiap.tech_challenge_02")
public class TechChallenge02Application {

	public static void main(String[] args) {
		SpringApplication.run(TechChallenge02Application.class, args);
	}

}
