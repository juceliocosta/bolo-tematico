package com.java.bolo_tematico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodSecurity
	public class BoloTematicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoloTematicoApplication.class, args);
	}

}
