package com.berzinc.pettracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PettrackerApplication {

	@RequestMapping("/aboutus.html")
    String home() {
		//making database calls
        return "<h1>Hello World!</h1>";
    }


	public static void main(String[] args) {
		SpringApplication.run(PettrackerApplication.class, args);
	}

}
