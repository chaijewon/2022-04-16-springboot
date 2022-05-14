<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     0. EL => 표현식  <%= %>(대신 사용) => 화면에 데이터를 출력  (thymeleaf)
     1. 사용법 
        ${exp} 
          --- 
           => 출력하는 내용이 일반변수가 아니고 
              request,session에 있는 값을 읽어서 출력 
              ${requestScope.키} , ${sessionScope.키}
      2. 연산자 
                 산술연산자 +,-,*,/,%
                 / => 정수/정수=실수  => div  ${10/3} => 3.333..
                                          ${10 div 3}
                 % => mod   => ${10%3} => 1 , ${10 mod 3}
                 
                 ***순수하게 산술만 가능
                 ${"a"+1} => 오류 (문자열 결합이 안된다)
                 ${"10"+1} => 11 (자동으로 정수형으로 변경후 연산처리)
                 ${10+null} => null(0) => 10
                               문자열 결합 (+=)
                 ${"Hello" += "Java"}  
                 비교연산자 : true => 조건문
                 == , eq  ${10==10} ${10 eq 10}
                 != , ne  ${20!=20} ${20 ne 20}
                 <  , lt
                 >  , gt
                 <= , le
                 >= , ge
                 *** 문자열이나 날짜 비교 ==,!=
                 논리연산자 : && , ||
                   && , and 
                   || , or 
                 삼항연산자 : (조건)?값:값
 --%>
<%
    String name="홍길동";
    request.setAttribute("name", name); // request.getAttribute("name");
    String sex="남자";
    session.setAttribute("sex", sex);
    
    String addr="서울";
    request.setAttribute("addr", addr);
    String address="부산";
    session.setAttribute("addr", address);
    // requestScope.,sessionScope.생략 => 같은 키를 가지고 있는 경우 request가 우선 순위 
    		
    /*
          1. 사용자 요청 
          2. Controller : 요청을 받는다 
          3. Controller => 요청을 처리 할 수 있게 Model클래스를 찾는다 
                           ---------------------------------- HandlerMapping
          4. Model => 요청을 처리하고 
                      결과값을 request/session에 담아 준다 
            => setAttribute => getAttribute => ${}  
          5. Controller => request/session을 받는다 
          6. JSP를 찾는다 
             ----------- ViewResolver
          7. JSP => 결과값이 담긴 request,session을 전송  
    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  이름:${name }<br>
 이름:${requestScope.name}<br>
 성별:${sex }<br>
 성별:${sessionScope.sex }<br>
 주소:${addr }
</body>
</html>






