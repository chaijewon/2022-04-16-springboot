package com.it.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.it.vo.*;
import com.it.dao.*;
@RestController
public class FoodRestController {
    @Autowired
    private FoodDAO dao;
    
    @RequestMapping(value = "food/rest_find.do",produces = "text/plain;charset=utf-8")
    public String food_res_find(int page,String ss)
    {
    	String result="";
    	try
    	{
    		int start=(page*12)-12;
    		Map map=new HashMap();
    		map.put("start", start);
    		map.put("ss",ss);
    		List<FoodVO> list=dao.foodFindData(map);
    		int totalpage=dao.foodFindTotalPage(ss);
    		
    		// JavaScript인식 => JSON => [{no:1,name:'',poster:''},{},{}]
    		JSONArray arr=new JSONArray();
    		int k=0;
    		for(FoodVO vo:list)
    		{
    			JSONObject obj=new JSONObject();
    			obj.put("no", vo.getNo());
    			obj.put("name", vo.getName());
    			obj.put("poster", vo.getPoster());
    			if(k==0)
    			{
    				obj.put("curpage", page);
        			obj.put("totalpage", totalpage);
    			}
    			k++;
    			
    			arr.add(obj);
    		}
    		result=arr.toJSONString();
    	}catch(Exception ex){}
    	return result;
    }
}
