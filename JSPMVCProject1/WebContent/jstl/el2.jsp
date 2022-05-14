<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
    List<String> list=new ArrayList<String>();
    list.add("red");
    list.add("blue");
    list.add("green");
    
    request.setAttribute("list", list);
    
    String[] names={"홍길동","심청이","박문수"};
    request.setAttribute("names", names);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>연산자 = 산술연산자 </h1>
 <%-- ${ 10+10}<br>
 ${ "10"+10 }<br>Integer.parseInt("10")
 ${ "a"+=1 }<br>문자열 결합
 ${ null+10 }<br>null은 0으로 인식
 ${ 10/3 }<br> 정수/정수=실수
 ${10 div 3 }
 ${10%3 }<br>
 <h1>비교연산자(조건)</h1>
 ${10<6 }<br> 10 lt 6
 ${10==6 }<br> 10 eq 6
 ${10!=6 }<br> 10 ne 6
 ${10<=6 }<br> 10 le 6
 ${10>6 }<br> 10 gt 6
 ${10>=6 }<br> 10 ge 6
 <h1>논리연산자</h1>
 ${ 20<6 && 20==6 }<br> 20<6 and 20==6
 ${ 20>6 || 20==6 }<br> 20>6 or 20==6
 <h1>삼항연산자</h1>
 ${ 10>6?"정답":"오답" }<br>
 ${ 10<6?"정답":"오답" }<br>
 ${list }<br>
 ${names } --%>
</body>
</html>