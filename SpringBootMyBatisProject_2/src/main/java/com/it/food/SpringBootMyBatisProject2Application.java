package com.it.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.food.controller","com.it.food.dao","com.it.food.service"})
public class SpringBootMyBatisProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisProject2Application.class, args);
	}

}
