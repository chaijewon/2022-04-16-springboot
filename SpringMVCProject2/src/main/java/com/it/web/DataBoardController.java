package com.it.web;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
	   if(page==null)
		   page="1"; 
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-rowSize;
	   map.put("rowSize", rowSize);
	   map.put("start",start);
	   List<DataBoardVO> list=dao.databoardListData(map);
	   int totalpage=dao.databoardTotalPage();
	   /*
	    *   @Select("SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
    	   +"FROM databoard "
    	   +"ORDER BY no DESC "
    	   +"limit #{start},#{rowSize}")
	    */
	   // JSP로 데이터 전송 => 출력 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "databoard/list";
   }
   @GetMapping("insert.do")
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   @PostMapping("insert_ok.do")
   
   public String databoard_insert_ok(DataBoardVO vo)
   {
	   List<MultipartFile> list=vo.getFiles();
	   // 파일 업로드받기 
	   if(list==null) // 업로드가 안된 상태
	   {
		   vo.setFilename("");
		   vo.setFilesize("");
		   vo.setFilecount(0);
	   }
	   else //업로드가 된 상태 
	   {
		   String tn="";
		   String ts="";
		   for(MultipartFile mf:list)
		   {
			   String fn=mf.getOriginalFilename();// 사용자가 보낸 파일명 
			   File file=new File("D:\\0416WeekDev\\upload\\"+fn);// 정보 확인 
			   try
			   {
				   // 파일을 지정된 폴더로 이동 
				   mf.transferTo(file);
			   }catch(Exception ex){} // a.jpg,b.jpg
			   tn+=fn+",";
			   ts+=file.length()+",";
		   }
		   tn=tn.substring(0,tn.lastIndexOf(","));// 마자막 콤마 제거
		   ts=ts.substring(0,ts.lastIndexOf(","));
		   vo.setFilename(tn);
		   vo.setFilesize(ts);
		   vo.setFilecount(list.size());
	   }
	   dao.databoardInsert(vo);
	   return "redirect:list.do"; // 재전송 => redirect
   }
}






