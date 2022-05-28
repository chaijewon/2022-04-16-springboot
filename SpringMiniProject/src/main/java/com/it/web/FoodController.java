package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	   List<FoodVO> list=dao.foodCategoryList(cno);
	   for(FoodVO vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0, poster.indexOf("^"));//5개
		   vo.setPoster(poster);
		   
		   String address=vo.getAddress();
		   address=address.substring(0,address.lastIndexOf("지"));//길 => 지번
		   vo.setAddress(address);
	   }
	   CategoryVO vo=dao.categoryInfoData(cno);
	   
	   // 전송
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../food/category_list.jsp");
	   return "main/main";
   }
   
   @GetMapping("food/food_detail_before.do")
   public String food_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
   {
	   // Cookie 저장 
	   Cookie cookie=new Cookie("f"+no, String.valueOf(no)); // 문자열 저장이 가능 
	   // 저장 위치 
	   cookie.setPath("/");
	   // 저장 기간 
	   cookie.setMaxAge(60*60*24);
	   // 클라이언트 브라우저로 전송 
	   response.addCookie(cookie);
	   ra.addAttribute("no", no);
	   return "redirect:food_detail.do";
   }
   @GetMapping("food/food_detail.do")
   public String food_detail(int no,Model model)
   {
	   // DAO를 연결해서 데이터를 가지고 온다 
	   FoodVO vo=dao.foodDetailData(no);
	   String address=vo.getAddress();
	   String addr1=address.substring(0,address.lastIndexOf("지"));
	   String addr2=address.substring(address.lastIndexOf("지")+3);
	   model.addAttribute("vo", vo);
	   model.addAttribute("addr1", addr1);
	   model.addAttribute("addr2", addr2);
	   model.addAttribute("main_jsp", "../food/food_detail.jsp");
	   return "main/main";
   }
   
   @RequestMapping("food/location.do") // GET/POST동시에 사용 
   public String food_location(String page,String ss,Model model)
   {
	   if(ss==null)
		   ss="강남";
	   
	   if(page==null)
		   page="1";
	   
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*12)-12;
	   Map map=new HashMap();
	   map.put("ss", ss);
	   map.put("start",start);
	   List<FoodVO> list=dao.foodFindData(map);
	   
	   int totalpage=dao.foodFindTotalPage(ss);
	   
	   final int BLOCK=5;
	   /*
	    *   < [1][2][3][4][5] > ==> < [6][7][8][9][10] >
	    *     sp           ep          sp          ep
	    *     
	    *     sp => curpage (1~5) => 1   ep => 5
	    *           curpage (6~10) => 6  ep => 10
	    */
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("ss", ss);
	   model.addAttribute("main_jsp", "../food/location.jsp");
	   return "main/main";
   }
   
   @GetMapping("food/location_vue.do")
   public String food_location_vue(Model model)
   {
	   model.addAttribute("main_jsp", "../food/location_vue.jsp");
	   return "main/main";
   }
   
}







