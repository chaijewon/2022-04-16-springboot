<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>
<%
    // 한글 변환 
    request.setCharacterEncoding("UTF-8");
%>
<%-- 값을 받는다 --%>
<jsp:useBean id="vo" class="com.it.dao.BoardVO">
  <jsp:setProperty name="vo" property="*"/>
</jsp:useBean>
<%
     boolean bCheck=dao.boardUpdate(vo);
     if(bCheck==true)
     {
    	 response.sendRedirect("detail.jsp?no="+vo.getNo());
     }
     else
     {
%>
        <script>
         alert("비미번호가 틀립니다!!");
         history.back(); //이전 페이지 이동 (update.jsp)
        </script>
<%
     }
%>
<%--
    수정 데이터를 받아서 데이터베이스 연결 
    화면 이동 => 상세보기로 이동  
  -------
    비밀번호가 틀린 경우 / 비밀번호가 맞다 => detail.jsp
  --------------- history.back()
--%>
