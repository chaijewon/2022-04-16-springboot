package com.it.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.board.controller",
		"com.it.board.entity","com.it.board.dao"})
public class SpringBootJpaProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject1Application.class, args);
	}

}
