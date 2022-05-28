package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.it.dao.*;
@Controller
@RequestMapping("databoard/") // Spring4.3 ==> 
/*
 *  RequestMapping ===============> GetMapping / PostMapping
 *   => GET/POST                       GET          POST
 *  -------------- 사용자 요청 URI 
 */
public class DataBoardController {
   // 필요한 객체 얻기 (스프링)
   @Autowired
   private DataBoardDAO dao;
   
   @GetMapping("list.do")
   public String databoard_list(String page, Model model)
   {
	   
	   return "databoard/list";
   }
}






