package com.spring.data.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.data.jpa.demo.controller.ProductController;

@SpringBootApplication
public class SpringDataJpaDemo003Application implements CommandLineRunner {

	@Autowired
	private ProductController productController;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemo003Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productController.run();
		
	}

}
