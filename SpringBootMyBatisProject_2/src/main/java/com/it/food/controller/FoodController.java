package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.it.food.service.*;
import com.it.food.vo.*;
/*
 *   1. DB연결 
 *      => SQL => board-mapper.xml
 *      => BoardMapper에서 연결 
 *      => BoardService => BoardServiceImpl 구현 
 *      => Controller에서 호출 
 *      => JSP출력 
 */
@Controller
public class FoodController {
    @Autowired
	private BoardService service;//DAO
    @GetMapping("/")
    public String board_list(String page,Model model)
    {
	   //Model => 전송 객체
	   if(page==null)
		   page="1"; //default page지정
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int start=(curpage*10)-10;
	   map.put("start", start);
	   map.put("size",10);
	   List<BoardVO> list=service.boardListData(map);
	   // 총페이지 
	   int totalpage=service.boardTotalPage();
	   
	   // 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "list";
    }
    @GetMapping("/insert")
    public String board_insert()
    {
    	return "insert";
    }
    // <form>
    @PostMapping("/insert_ok")
    public String board_insert_ok(BoardVO vo)
    {
    	service.boardInsert(vo);
    	return "redirect:/";
    }
    @GetMapping("/detail")
    public String board_detail(int no,Model model)
    {
    	BoardVO vo=service.boardDetailData(no);
    	model.addAttribute("vo", vo);
    	return "detail";
    }
    @GetMapping("/update")
    public String board_update(int no,Model model)
    {
    	BoardVO vo=service.boardUpdateData(no);
    	model.addAttribute("vo", vo);
    	return "update"; // forward => request를 전송 ==> Model
    }
    @PostMapping("/update_ok")
    public String board_update_ok(BoardVO vo,RedirectAttributes ra)
    {
    	// 수정 
    	service.boardUpdate(vo);
    	ra.addAttribute("no", vo.getNo());
    	// RedirectAttributes를 이용해서 데이터 전송 
    	return "redirect:/detail"; // request를 초기화 => 재전송 (sendRedirect())
    }
    @GetMapping("/delete")
    public String board_delete(int no)
    {
    	service.boardDelete(no);
    	return "redirect:/";
    }
}
