package com.intraway.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class FizzbuzzServicesApiApplication {

	/**
	 * Fizz Buzz Application
	 * @author Pablo Mendez
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzServicesApiApplication.class, args);
	}

}
