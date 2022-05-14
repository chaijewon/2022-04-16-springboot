package com.it.model;

import javax.servlet.http.HttpServletRequest;

import com.it.controller.RequestMapping;
import java.util.*;
import com.it.dao.*;
public class MainModel {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request)
   {
	   List<FoodCategoryVO> list=FoodDAO.foodCategoryData();
	   request.setAttribute("list", list);
	   request.setAttribute("main_jsp", "../main/home.jsp");
	   return "../main/main.jsp";
   }
}
