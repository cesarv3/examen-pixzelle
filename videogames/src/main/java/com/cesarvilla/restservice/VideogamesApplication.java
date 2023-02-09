package com.cesarvilla.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cesarvilla")
public class VideogamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideogamesApplication.class, args);
	}

}
