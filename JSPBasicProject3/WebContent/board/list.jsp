<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*,java.text.*" errorPage="error.jsp"%>
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>
<%-- BoardDAO dao=new BoardDAO() 
     id="dao" class="com.it.dao.BoardDAO"
     --------       ---------------------
            객체명                Class.forName("com.it.dao.BoardDAO"); => 메모리 할당
            <jsp:~~~> : JSP액션태그 
--%>
<%
    //int a=10/0;
    //1. 사용자 입력값 받기 (page)
    String strPage=request.getParameter("page"); // < [1][2][3] >
    // default페이지 설정 
    if(strPage==null)
    	strPage="1"; 
    // http://localhost/JSPBasicProject3/board/list.jsp
    // list.jsp  ===> request.getParameter("page") ==> null
    // list.jsp?page= request.getParameter("page") ==> ""
    // list.jsp?page=1 request.getParameter("page")==> "1"
    int curpage=Integer.parseInt(strPage);// 현재 페이지 
    
    //2. 데이터베이스로부터 데이터를 읽어 온다 
    List<BoardVO> list=dao.boardListData(curpage); 
    int totalpage=dao.boardTotalPage();
    
    // 페이지 나누기 
    final int BLOCK=3;
    // [1][2][3]    [4][5][6]  [7][8][9]
    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    // 현재페이지 => [1][2][3] ==> 1
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
    if(endPage>totalpage)
    	endPage=totalpage;
    //3. HTML안에 출력 
    String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    // 오늘 날짜 읽기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row {
  margin: 0px auto;
  width: 960px;
}
h1 {
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>자유게시판</h1>
     <div class="row">
       <table class="table">
         <tr>
           <td>
             <a href="insert.jsp" class="btn btn-sm btn-success">새글</a>
           </td>
         </tr>
       </table>
       <table class="table">
         <tr class="danger">
          <th class="text-center" width=10%>번호</th>
          <th class="text-center" width=45%>제목</th>
          <th class="text-center" width=15%>이름</th>
          <th class="text-center" width=20%>작성일</th>
          <th class="text-center" width=10%>조회수</th>
         </tr>
         <%
             // <c:forEach var="vo" items="list">
             for(BoardVO vo:list)// 출력 전용 (for-each)=>향상된 for (컬렉션 , 배열에서만 사용이 가능)
             {
         %>
                 <tr>
		          <td class="text-center" width=10%><%=vo.getNo() %></td>
		          <td width=45%>
		            <a href="detail.jsp?no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>&nbsp;
		            <%
		                if(today.equals(vo.getDbday()))
		                {
		                	// 문자열 비교 
		            %>
		                    <sup style="color:red">new</sup>
		            <%
		                }
		            %>
		          </td>
		          <td class="text-center" width=15%><%=vo.getName() %></td>
		          <td class="text-center" width=20%><%=vo.getDbday() %></td>
		          <td class="text-center" width=10%><%=vo.getHit() %></td>
		         </tr>
         <%
             }
         %>
       </table>
     </div>
     <div class="row">
       <div class="text-center">
          <ul class="pagination">
             <%
                  if(startPage>1) //startPage=1,4,7...
                  {
                	  %>
 			         <li><a href="list.jsp?page=<%=startPage-1%>">&lt;</a></li>
 			  <%
                   }
 			  %>
 			  <%
 			      for(int i=startPage;i<=endPage;i++)
 			      {
 			    	  String css="";
 			    	  if(curpage==i)
 			    		  css="class=active";
 			    	  else
 			    		  css="";
 			  %>
 			          <li <%=css %>><a href="list.jsp?page=<%=i%>"><%=i %></a></li>
 			  <%
 			      }
 			  %>
 			  <%
 			     if(endPage<totalpage)
 			     {
 			  %>
 			        <li><a href="list.jsp?page=<%=endPage+1%>">&gt;</a></li>
 			  <%
 			     }
 			  %>
 			</ul>
        </div>
      </div>
    </div>
 </body>
 </html>



