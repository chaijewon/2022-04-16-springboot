package com.it.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.it.dao.FoodDAO;
import com.it.vo.CategoryVO;
import com.it.vo.FoodVO;

@Controller
public class MainController {
   @Autowired
   private FoodDAO dao;
   @GetMapping("main/main.do")
   public String main_main(Model model,HttpServletRequest request)
   {
	   // 쿠키 
	   List<FoodVO> cList=new ArrayList<FoodVO>();
       Cookie[] cookies=request.getCookies();
       if(cookies!=null)
       {
    	   for(int i=cookies.length-1;i>=0;i--)
    	   {
    		   if(cookies[i].getName().startsWith("f"))
    		   {
    			   String no=cookies[i].getValue();
    			   FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
    			   cList.add(vo);
    		   }
    	   }
       }
       model.addAttribute("cList", cList);
	   List<CategoryVO> list=dao.categoryAllData();
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
}








