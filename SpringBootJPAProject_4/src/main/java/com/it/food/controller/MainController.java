package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.it.food.dao.*;
import com.it.food.entity.*;
@Controller
public class MainController {
   @Autowired
   private FoodDAO dao;
   @GetMapping("/main")
   public String main_page(String address,String page,Model model)
   {
	   if(page==null)
		   page="1";
	   if(address==null)
		   address="강남";
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*20)-20;
	   List<FoodEntity> list=dao.foodFindData(address, start);
	   for(FoodEntity vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   vo.setPoster(poster);
	   }
	   int totalpage=dao.foodTotalPage(address);
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("address", address);
	   model.addAttribute("main_content", "food/category");
	   return "main";
   }
   @GetMapping("/music/list")
   public String music_list(Model model)
   {
	   model.addAttribute("main_content", "music/list");
	   return "main";
   }
   @GetMapping("/movie/list")
   public String movie_list(Model model)
   {
	   model.addAttribute("main_content", "movie/list");
	   return "main";
   }
   @GetMapping("/board/list")
   public String board_list(Model model)
   {
	   model.addAttribute("main_content", "board/list");
	   return "main";
   }
}
