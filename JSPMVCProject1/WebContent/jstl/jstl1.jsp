<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
     prefix="c"
     <c:~>
     prefix="core"
     <core:~>
--%>
<%--
    JSTL => JavaServer Pages Standard Tag Library
         => 제어문 / 변환 / 문자열 (tag형으로 제작)
         => core
            1.변수 선언 
              <c:set var="name" value="<%="박문수"%>">
                => request.setAttribute("name","박문수")
            2. 화면 출력 : jquery (충돌) => <c:out value=""/> 그래프 , 맵
            3. 제어문 
                <c:if> 조건문
                <c:forEach> 반복문
                <c:choose> : 선택문,다중 조건문 
            4. 화면이동 
                <c:redirect url=""> 
         => fmt
            1. 날짜 변환 : <fmt:formatDate> 
            2. 숫자 변환 : <fmt:formatNumber>
         => fn : String클래스의 메소드 
            ${fn:substring()} ${fn:trim()} 
         -------- 사용빈도가 없다 
         => xml --> OXM(jaxb,jaxp)
         => sql --> ORM(mybatis,jpa)
         --------
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 1 조건문 (단점:else가 없다) --%>
  <%
      int sex=1;
  %>
  <h1>Java(if)</h1>
  <%
      if(sex==1)
      {
  %>
      <h3>남자</h3>
  <%
      }
      else
      {
  %>
         <h3>여자</h3>
  <%
      }
  %>
  <c:set var="sex" value="2"/> <%-- request.setAttribute("sex",2) --%>
  <c:if test="${sex==1 }">
    <h3>남자</h3>
  </c:if>
  <c:if test="${sex!=1 }">
    <h3>여자</h3>
  </c:if>
  <%-- if~else --%>
  <c:choose>
    <c:when test="${sex==1 }">남자</c:when>
    <c:otherwise>여자</c:otherwise>
  </c:choose>
  <hr>
  <h1>반복문(for):자바</h1>
  <%
      for(int i=1;i<=10;i++)
      {
  %>
         <%= i+"&nbsp;" %>
  <%
      }
  %>
  <h1>반복문(for):JSTL</h1>
  <c:forEach var="i" begin="1" end="10" step="1"><%-- 감소가 없다 --%>
     ${i }&nbsp;
  </c:forEach>
  <h1>반복문 (for-each):자바</h1>
  <%
     List<String> list=new ArrayList<String>();
     list.add("홍길동");
     list.add("심청이");
     list.add("박문수");
     list.add("이순신");
     list.add("강감찬");
  %>
  <%
      for(String name:list)
      {
  %>
         <%=name %><br>
  <%
      }
  %>
  <%--
     request.setAttribute("list", list);
  --%>
  <c:set var="list" value="<%=list %>"/>
  <h1>반복문(for-each):JSTL</h1>
  <c:forEach var="name" items="${list }">
    ${name }<br>
  </c:forEach>
  <h1>자바 : StringTokenizer</h1>
  <%
       String color="red,green,blue,black,yeollow";
       StringTokenizer st=new StringTokenizer(color,",");
       while(st.hasMoreTokens())
       {
  %>
          <%=st.nextToken() %>&nbsp;
  <%
       }
  %>
  <h1>JSTL:StringTokenizer</h1>
  <c:forTokens var="color" items="red,green,blue,black,yeollow" delims=",">
     ${color }&nbsp;
  </c:forTokens>
  <h1>Java:날짜 변환</h1>
  <%
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String today=sdf.format(date);
  %>
  <%= date %><br>
  <%= today %>
  <h1>JSTL:날짜변환</h1>
  <fmt:formatDate value="<%=date %>" pattern="yyyy-MM-dd"/>
  <h1>JSTL:숫자변환</h1>
  <fmt:formatNumber value="10000000" pattern="0,000"/>원
  <h1>Java:문자열 자르기</h1>
  <%
      String s="Hello Java!!";
      String res=s.substring(0,5);//5은 제외 
  %>
  <%= res %><br>
  <c:set var="s" value="Hello Java!!"/>
  ${fn:substring(s,0,5) }
</body>
</html>









