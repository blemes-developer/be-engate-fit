package com.engate.fitness.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		IO.println("Starting Fitness API Application...");
		SpringApplication.run(Application.class, args);
	}

}
