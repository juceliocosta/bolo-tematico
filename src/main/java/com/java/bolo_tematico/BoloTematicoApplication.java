package com.java.bolo_tematico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //isso é necessário para detectar o @WebFilter
	public class BoloTematicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoloTematicoApplication.class, args);
	}

}
