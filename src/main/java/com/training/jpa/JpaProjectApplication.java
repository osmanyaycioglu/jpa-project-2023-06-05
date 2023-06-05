package com.training.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
// @EntityScan(basePackages = {})
public class JpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

}
