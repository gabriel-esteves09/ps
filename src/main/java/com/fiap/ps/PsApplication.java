package com.fiap.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PsApplication {
	
	@GetMapping("/")
	public String get() {
		return "Bem vindo a Rest API";
	}

	public static void main(String[] args) {
		SpringApplication.run(PsApplication.class, args);
	}

}
