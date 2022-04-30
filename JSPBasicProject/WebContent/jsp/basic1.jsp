<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       JSP (Java Server Page) : 서버에서 실행되는 자바 파일 
         => 최근 
                      서버(스프링/부트) <===> Front(React,Vue,Html(Thymeleaf))
         => 1) 지시자 
                page : JSP에 대한 정보  
                             형식) <%@ page   속성="값" 속성="값" .... %>
                                      속성
                       contentType => 브라우저가 읽어 갈때 어떤 형태 확인 
                           html => text/html;charset=utf-8
                           xml  => text/xml;charset=utf-8
                           json => text/plain;charset=utf-8
                       errorPage  => 에러가 난 경우에 해당 보여주는 파일로 이동 
                       import => 자바라이브러리 읽어 올때 
                                 java.lang,javax.http.servlet => 생략이 가능 
                       buffer => HTML를 저장하는 메모리 공간 
                                 ---------------------- 브라우저
                                 default : 8kb => 16kb...
                       * 단) 속성은 한번만 사용이 가능 
                                                    예외 => import
                         <%@ page import="java.util.*,java.io.*"%> 
                         <%@ page import="java.util.*"%> 
                         <%@ page import="java.io.*"%> 
                       info : 제작자 , 수정 날짜 ...
               -------------------------------------------------------------
                taglib : 제어문 (자바) , 화면이동 , 변경 , String메소드 => 태그로 제작 
                include : 템플릿 (JSP안에 특정부분에 다른 JSP를 첨부해서 사용) => 조립식 
               -------------------------------------------------------------
            2) 자바/HTML 분리 (구분) => 스크립트릿 
                <% %> : 스크립트릿 => 일반 자바 
                                            지역변수 선언,메소드 호출 , 제어문사용 ... 
                <%! %> : 선언식
                         => 메소드 제작 , 멤버변수 선언 (사용빈도가 거의 없다)
                <%= %> : 표현식 : 브라우저에 출력 
            3) 내장 객체 :  미리 생성된 객체
                 ***request : 가장 많이 사용되는 내장 객체
                      http://localhost/JSPBasicProject/jsp/basic1.jsp 
                      http://localhost:8080 /JSPBasicProject/jsp/basic1.jsp => URL
                      --------------------- -------------------------------
                                                     URI
                      ----   ---------- ----
                      Protocol  서버명   포트 
                      = 서버 정보 
                        getServerInfo()
                        getServerPort()  => 0~65535 (80(http),23(Telnet),21(Ftp),25(SMTP),4000(머드서버)
                      = 사용자 정보
                        getRemoteAddr() => 접속한 사람의 IP
                      = 사용자 요청 정보 (사용자 보낸 모든 데이터를 묶어서 전송) => 톰캣에 의해 전송
                        = String getParameter()
                          a.jsp?page=1
                          String page=request.getParameter("page")
                             => 정수 : Integer.parseInt(page);
                                                          실수 : Double.parseDouble(page);
                                                          논리 : Boolean.parseBoolean(page);
                                **웹에서 전송받는 모든 데이터는 문자열이다
                        = String[] getParameterValues()
                              => checkbox 
                      = 데이터 추가후 전송 
                        setAttribute() , getAttribute()  ==> MVC  
                         
                 ***response 
                      => 응답 정보 , 쿠키 저장 
                         ------- HTML , Cookie => JSP한개에서 두개 동시에 보낼 수 없다 
                         => addCookie()
                         => setHeader()
                      => 화면 이동 : redirect (재전송)
                         => sendRedirect()
                 ***pageContext; // 내장객체 얻기 , request공유 , 화면이동 
                                                include()     forward()
			     ***session = null; // 서버에 사용자의 일부 정보 , 장바구니 정보 
			     ***application; // getRealPath() , log() => 서버와 관련된 정보를 가지고 있다 
			                       -------------- 실제 저장 위치 
			      
				    public void _jspService()
				    {
				          
				         --------------------------
				         
				         --------------------------
				    }
            4) 액션 태그 
                <jsp:inlude> <jsp:forward> <jsp:setProperty> <jsp:useBean>
            5) JSTL/EL => EL은 화면 출력 (표현식)
               ---- 제어문 , 변수선언 , 화면이동 , 변경 , String-method 
               ------------------------------------------------- 태그형으로 변경 
                     <%
                         for(int i=0;i<10;i++)
                         {
                     %>
                                <li></li>
                     <%
                         }
                     %>
                     
                     <c:forEah var="i" begin="0" end="10">
                       <li></li>
                     </c:forEach>
            6) MVC : 자바와 HTML분리해서 코딩 
                
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   String name="홍길동";
   out.println(name);
   %>
</body>
</html>








