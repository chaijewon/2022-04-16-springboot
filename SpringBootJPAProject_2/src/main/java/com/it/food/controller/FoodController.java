package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.it.food.dao.*;
import com.it.food.entity.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("/food_find")
   public String food_find(String page,String address,Model model)
   {
	   return "food/list";
   }
   @GetMapping("/food_detail")
   public String food_detail(int no,Model model)
   {
	   return "food/detail";
   }
}
