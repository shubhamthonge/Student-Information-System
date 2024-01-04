package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SbDay5Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDay5Application.class, args);
	}


	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("inside getRestTemplate");
		return new RestTemplate();
	}
}
