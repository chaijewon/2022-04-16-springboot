package com.it.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.it.music.dao.*;
import com.it.music.entity.*;
@RestController
public class MusicRestController {
   // JSON
	@Autowired
	private MusicDAO dao;
	
	@PostMapping("/detail")
	public MusicEntity music_detail(int no)
	{
		MusicEntity vo=dao.findByNo(no);
		System.out.println(vo);
		return vo;
	}
   
}
