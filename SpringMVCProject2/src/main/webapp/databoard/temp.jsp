<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<String> names=new ArrayList<String>();
    List<String> address=new ArrayList<String>();
    
    names.add("홍길동");
    names.add("심청이");
    names.add("박문수");
    
    address.add("서울");
    address.add("부산");
    address.add("제주");
%>
<c:set var="nList" value="<%=names %>"/>
<c:set var="aList" value="<%=address%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <ul>
    <c:forEach var="name" items="${nList }" varStatus="s">
      <li>${name }(${aList[s.index]})</li>
    </c:forEach>
   </ul>
</body>
</html>