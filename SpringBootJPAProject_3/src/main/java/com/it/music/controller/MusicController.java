package com.it.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.it.music.dao.*;
import com.it.music.entity.*;
@Controller
public class MusicController {
    @Autowired
    private MusicDAO dao;
    
    @GetMapping("/list")
    public String music_list(Model model)
    {
    	List<MusicEntity> list=dao.findAll();
    	model.addAttribute("list", list);
    	return "music/list";
    }
    
}
