package com.example.AmazonSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.AmazonSpring.controllers.UserController;
import com.example.AmazonSpring.controllers.ProductController;

@SpringBootApplication
public class AmazonSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonSpringApplication.class, args);
	}

}
