package com.it.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.music.controller","com.it.music.dao","com.it.music.entity"})
public class SpringBootJpaProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject3Application.class, args);
	}

}
