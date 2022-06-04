package com.it.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
   @GetMapping("/hello")
   public String hello_main()
   {
	   return "hello";
   }
}
