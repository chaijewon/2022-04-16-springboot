<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 제어문 , URL 이동 (core) --%>
<jsp:useBean id="model" class="com.it.model.MemberModel"/>
<%
       model.memberLogin(request); //JSP마다 request를 가지고 있다  => Controller
       // 처리하는 소스만 => 자바 
%>
<c:choose>
  <c:when test="${result=='NOID' }">
   <script>
    alert("아이디가 존재하지 않습니다!!");
    history.back();
   </script>
  </c:when>
  <c:when test="${result=='NOPWD' }">
   <script>
    alert("비밀번호가 틀립니다!!");
    history.back();
   </script>
  </c:when>
  <c:otherwise>
    <c:redirect url="category.jsp"/>
  </c:otherwise>
</c:choose>
