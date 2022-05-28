package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.it.dao.*;
import com.it.vo.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("food/category_list.do")
   public String food_category_list(int cno,Model model)
   {
	   // DAO에서 데이터를 읽어서 전송 
	   model.addAttribute("main_jsp", "../food/category_list.jsp");
	   return "main/main";
   }
   
}







