package com.it.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.it.board.dao.*;
import com.it.board.entity.*;
@Controller
public class BoardController {
	@Autowired
    private BoardDAO dao;
	
	@GetMapping("/list")
    public String board_list(String page,Model model)
    {
	   //Model => 전송 객체
	   if(page==null)
		   page="1"; //default page지정
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*10)-10;
	  
	   List<BoardEntity> list=dao.boardListData(start);
	   // 총페이지 
	   int totalpage=dao.boardTotalPage();
	   
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
    public String board_insert_ok(BoardEntity vo)
    {
    	dao.save(vo);
    	return "redirect:/list";
    }
    @GetMapping("/detail")
    public String board_detail(int no,Model model)
    {
    	BoardEntity vo=dao.findByNo(no);
    	vo.setHit(vo.getHit()+1);//조회수 증가
    	dao.save(vo);
    	vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	return "detail";
    }
    @GetMapping("/update")
    public String board_update(int no,Model model)
    {
    	BoardEntity vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	return "update"; // forward => request를 전송 ==> Model
    }
    @PostMapping("/update_ok")
    public String board_update_ok(BoardEntity vo,RedirectAttributes ra)
    {
    	dao.save(vo);
    	ra.addAttribute("no", vo.getNo());
    	return "redirect:/detail"; // request를 초기화 => 재전송 (sendRedirect())
    }
    @GetMapping("/delete")
    public String board_delete(int no)
    {
    	//service.boardDelete(no);
    	BoardEntity vo=dao.findByNo(no);
    	dao.delete(vo);
    	return "redirect:/list";
    }
}
