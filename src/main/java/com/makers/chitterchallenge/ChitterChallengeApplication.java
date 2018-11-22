package com.makers.chitterchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChitterChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChitterChallengeApplication.class, args);
	}
}


