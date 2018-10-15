package com.eddyfajar.billyon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BillyonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillyonApplication.class, args);
	}
}
