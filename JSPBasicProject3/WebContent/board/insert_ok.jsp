<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>
<%
   // 화면 출력(X)
   // 사용자 입력을 받아서 => 데이터베이스 연결 => 화면이동  _ok 
   // 1. 한글 변환  => encoding(%ED%99%8D%EA%B8%B8%EB%8F%99) => decoding(홍길동) 
   request.setCharacterEncoding("UTF-8"); 
   /*
       http://localhost/JSPBasicProject3/board/insert_ok.jsp?name=%ED%99%8D%EA%B8%B8%EB%8F%99&subject=%ED%95%9C%EA%B8%80&content=%ED%95%9C%EA%B8%80&pwd=1234
   */
%>
<%--
     jsp:useBean : 클래스 메모리할당
     jsp:setProperty : 사용자가 전송한 값을 ~VO에 채워서 처리한다 
     jsp:include 
 --%>
<jsp:useBean id="vo" class="com.it.dao.BoardVO">
 <jsp:setProperty name="vo" property="*"/>
</jsp:useBean>
<%
    dao.boardInsert(vo);
    response.sendRedirect("list.jsp");
%>
<%--
   BoardVO vo=new BoardVO();
   String name=request.getParameter("name");
   String subject=request.getParameter("subject");
   String content=request.getParameter("content");
   String pwd=request.getParameter("pwd");
   
   vo.setName(name);
   vo.setSubject(subject);
   vo.setContent(content);
   vo.setPwd(pwd);
   
   //DAO연결
   BoardDAO dao=new BoardDAO();
   dao.boardInsert(vo);
   //화면이동 
   response.sendRedirect("list.jsp");//재전송 
--%>
