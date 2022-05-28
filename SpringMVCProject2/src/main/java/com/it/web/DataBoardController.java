package com.it.web;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

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
	   return "databoard/insert";//forward
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
   @GetMapping("detail.do")
   // 매개변수 => DispatcherServlet
   /*
    *   매개변수 => 순서가 없다 
    *   1. 사용자가 값을 전송하지 않는 경우 => String 
    *      무조건 값을 전송 => 해당 데이터형으로 사용 
    *   2. 체크박스 => 값이 여러개 동시에 => String[]
    *   3. file[0],file[1] ==> List 
    *      ---------------------------------------  400 bad request
    *   4. JSP로 전송 => Model(forward):databoard/insert , RedirectAttribute(redirect):redirect:list.do
    *   5. 기본객체 
    *      HttpServletRequest : Cookie 
    *      HttpServletResponse : 다운로드 
    *      HttpSession : 로그인 
    *   -----------------------------------------------
    *   리턴형 
    *    => String : 파일 전송 => 해당 파일을 찾아서 출력 요청 
    *    => void : 다운로드 ,Ajax 
    */
   public String databoard_detail(int no,Model model)
   {
	   //1. 데이터베이스 읽기 
	   DataBoardVO vo=dao.databoardDetailData(no);
	   List<String> fn=new ArrayList<String>();// 파일명 목록 (a.jpg,b.jpg...)
	   List<String> fs=new ArrayList<String>();// 파일크기 (1000,2000,200)
	   
	   String s1=vo.getFilename();
	   String s2=vo.getFilesize();
	   
	   if(vo.getFilecount()!=0)// 파일이 업로드된 상태 
	   {
		   StringTokenizer st=new StringTokenizer(s1,",");
		   while(st.hasMoreTokens())
		   {
			   fn.add(st.nextToken());
		   }
		   
		   st=new StringTokenizer(s2,",");
		   while(st.hasMoreTokens())
		   {
			   fs.add(st.nextToken());
		   }
		   
		   model.addAttribute("fn", fn);
		   model.addAttribute("fs", fs);
	   }
	   
	   model.addAttribute("vo", vo);
	   
	   return "databoard/detail";
   }
   // 다운로드 
   @GetMapping("download.do")
   public void databoard_download(String fn,HttpServletResponse response)
   {
	   // request => 클라이언트로부터 값을 받는다 
	   // response => 클라이언트에 결과값 전송 (HTML,Cookie,파일)
	   try
	   {
		   // 파일 정보 얻기 
		   File file=new File("D:\\0416WeekDev\\upload\\"+fn);
		   // 사전에 전송 => header
		   response.setHeader("Content-Disposition", "attachment;filename="
				   +URLEncoder.encode(fn, "UTF-8"));
		   
		   // 다운로드시 파일 전송 
		   BufferedInputStream bis=
				   new BufferedInputStream(new FileInputStream(file));
		   BufferedOutputStream bos=
				   new BufferedOutputStream(response.getOutputStream());
		   byte[] buffer=new byte[1024];
		   // TCP => 1024 , UDP => 512
		   int i=0; // 읽은 바이트수 
		   while((i=bis.read(buffer,0,1024))!=-1) //-1 EOF (파일의 끝)
		   {
			   bos.write(buffer,0,i);
		   }
		   bis.close();
		   bos.close();
	   }catch(Exception ex){}
   }
   //1. 삭제 폼 
   @GetMapping("delete.do")
   public String databoard_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "databoard/delete";
   }
}






