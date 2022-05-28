package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.it.dao.*;
@RestController
public class DataBoardRestController {
    @Autowired
    private DataBoardDAO dao;
    
    @RequestMapping("databoard/delete_ok.do")
    public String databoard_delete_ok(int no,String pwd)
    {
    	
    	String result=""; //<script> ---
    	return result;
    }
}
