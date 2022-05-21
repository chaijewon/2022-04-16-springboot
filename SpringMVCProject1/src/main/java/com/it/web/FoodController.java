package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.it.dao.*;
@Controller // 메모리할당 (HandlerMapping=>찾는 클래스)
public class FoodController {
    // 필요한 클래스 => 스프링에 요청
    @Autowired
	private FoodDAO dao;
    
    /*
     *   메소드 찾아서 => 수행 
     *   ----------
     *   @RequestMapping => 4.3 => @GetMapping , @PostMapping 
     *                             ------------  -------------
     *                               Get방식             Post방식
     *   ---------------
     *     Get/Post를 동시에 처리가 가능 
     */
    @RequestMapping("food/category.do")
    public String food_category(Model model)
    {
    	// Model => 전송객체 (JSP값을 전송 할때)
    	//1. DAO에서 값을 가지고 온다 
    	List<CategoryVO> list=dao.categoryListData();
    	model.addAttribute("list", list);
    	return "food/category";// 파일명만 설정 
    }
    @RequestMapping("food/food_list.do")
    public String food_list(int cno,Model model)
    {
    	List<FoodVO> list=dao.categoryFoodListData(cno);
    	for(FoodVO vo:list)
    	{
    		String poster=vo.getPoster();
    		poster=poster.substring(0,poster.indexOf("^"));
    		vo.setPoster(poster);
    	}
    	CategoryVO vo=dao.categoryInfodData(cno);
    	model.addAttribute("vo", vo);
    	model.addAttribute("list", list);
    	return "food/food_list";
    }
}







