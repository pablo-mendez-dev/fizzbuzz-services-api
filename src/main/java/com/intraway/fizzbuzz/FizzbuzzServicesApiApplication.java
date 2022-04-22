package com.intraway.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.intraway.fizzbuzz"})
//@EntityScan("com.intraway.fizzbuzz.domain.entities")
//@EnableJpaRepositories("com.intraway.fizzbuzz.domain.repository")
public class FizzbuzzServicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzServicesApiApplication.class, args);
	}

}
