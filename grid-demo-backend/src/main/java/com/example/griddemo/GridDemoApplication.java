package com.example.griddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.griddemo"})
public class GridDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridDemoApplication.class, args);
	}

}
