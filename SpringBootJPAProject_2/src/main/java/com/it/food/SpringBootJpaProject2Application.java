package com.it.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.food.controller","com.it.food.entity","com.it.food.dao"})
public class SpringBootJpaProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject2Application.class, args);
	}

}
