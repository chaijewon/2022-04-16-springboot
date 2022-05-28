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
    	boolean bCheck=dao.databoardDelete(no, pwd);
    	if(bCheck==true)// 삭제
    	{
    		result="<script>location.href=\"list.do\";</script>";
    	}
    	else //비밀번호가 틀린 상태 
    	{
    		result="<script>"
    			  +"alert(\"Password Fail!!\");"
    			  +"history.back();"
    			  +"</script>";
    	}
    	return result;
    }
}
