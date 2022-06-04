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
	   if(page==null)
		   page="1";
	   
	   if(address==null)
		   address="강남";
	   
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*20)-20;
	   
	   // 데이터 가지고 오기
	   List<FoodEntity> list=dao.foodFindData(address, start);
	   for(FoodEntity vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   vo.setPoster(poster);
	   }
	   int totalpage=dao.foodTotalPage(address);
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("address", address);
	   model.addAttribute("list", list);
	   return "food/list";
   }
   @GetMapping("/food_detail")
   public String food_detail(int no,Model model)
   {
	   return "food/detail";
   }
}
