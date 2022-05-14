<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
       Sawon sa=new Sawon(1,"홍길동","개발부","서울","사원");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Java:데이터 출력</h1>
   사번:<%=sa.getSabun() %><br>
  이름:<%=sa.getName() %><br>
  부서:<%=sa.getDept() %><br>
  근무지:<%=sa.getLoc() %><br>
  직위:<%=sa.getJob() %>
  <hr>
  <c:set var="sa" value="<%=sa %>"/><%-- request.setAttribute("sa",sa) --%>
  <h1>EL:데이터출력-1</h1>
   사번:${sa.getSabun() }<br>
  <%--이름:${sa.getName() }<br>--%>
  부서:${sa.getDept() }<br>
  근무지:${sa.getLoc() }<br>
  직위:${sa.getJob() }<br>
  <hr>
  <h1>EL:데이터출력-2</h1>
   사번:${sa.sabun }<br><%-- ${sa.getSabun() } --%>
  이름:${sa.name }<br>
  부서:${sa.dept }<br>
  근무지:${sa.loc }<br>
  직위:${sa.job }<br> <%-- {} => getXxx()
                         MyBatis
                         #{name},${}
                         => getName()
                     --%>
</body>
</html>






