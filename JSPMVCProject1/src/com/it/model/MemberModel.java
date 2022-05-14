package com.it.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//MV 구조 (자바처리 , JSP출력부분만 분리)
import com.it.dao.*;
public class MemberModel {
   public void memberLogin(HttpServletRequest request)
   {
	   // 사용자 전송한 ID,Pwd를 받는다 => request에 첨부  => <% %>
	   String id=request.getParameter("id");
	   String pwd=request.getParameter("pwd");
	   // DAO연동 
	   MemberDAO dao=new MemberDAO();
	   String result=dao.isLogin(id, pwd); 
	   if(!(result.equals("NOID")||result.equals("NOPWD")))
	   {
		   // 로그인 인증 
		   HttpSession session=request.getSession();
		   // 세션에 저장 => 서버에 저장 
		   /*
		    *   저장  : setAttribute(키,값) => Map => 키는 중복이되면 안된다 
		    *   값 읽기 : getAttribute(키) 
		    *   전체 해제 : invalidate() => 로그아웃 
		    *   저장기간  : 30분(default) => setMaxInactiveInterval(초) => 1800
		    *                             60*60*24
		    *   일부 해제  : removeAttribute(키) => 장바구니 , 찜
		    */
		   session.setAttribute("id", id);
		   session.setAttribute("name", result);
	   }
	   
	   //request에 결과값을 담아서 JSP로 전송 => 재전송 => JSP에서 ${} EL로 출력 
	   request.setAttribute("result", result); 
   }
}
