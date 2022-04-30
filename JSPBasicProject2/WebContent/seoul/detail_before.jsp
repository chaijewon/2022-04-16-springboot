<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // "detail_before.jsp?no=1
    //1. 사용자가 보내준 데이터를 받는다 (no변수)
    String no=request.getParameter("no");
    //2. 쿠키 생성 
    Cookie cookie=new Cookie("h"+no,no);
    // 클라이언트 브라우저에 저장 , 쿠키는 저장시에 문자열만 저장이 가능 
    // response가 전송 => HTML / Cookie 
    //3. 저장위치 결정 => setPath()
    cookie.setPath("/");
    //4. 저장기간 설정 => setMaxAge()
    cookie.setMaxAge(60*60*24); //1일 => 저장 (초단위 저장)
    //5. response를 이용해서 클라이언트로 전송 
    response.addCookie(cookie);
    //6. 상세보기 화면으로 이동 
    response.sendRedirect("detail.jsp?no="+no);
%>