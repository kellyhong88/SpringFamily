package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsApplication.class, args);
	}
}
