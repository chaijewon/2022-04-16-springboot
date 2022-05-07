<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>
<% 
      // list.jsp ==> 제목 click => detail.jsp=no=1;
      // 게시쿨 번호받기 
      String no=request.getParameter("no");
      BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
      //                            String => int로 변환 (데이터형과 관련된 클래스 : Wrapper)
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
  width: 700px;
}
h1 {
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>내용보기</h1>
     <div class="row">
       <table class="table">
        <tr>
         <th width=20% class="text-center danger">번호</th>
         <td width=30% class="text-center"><%=vo.getNo() %></td>
         <th width=20% class="text-center danger">작성일</th>
         <td width=30% class="text-center"><%=vo.getDbday() %></td>
        </tr>
        <tr>
         <th width=20% class="text-center danger">이름</th>
         <td width=30% class="text-center"><%=vo.getName() %></td>
         <th width=20% class="text-center danger">조회수</th>
         <td width=30% class="text-center"><%=vo.getHit() %></td>
        </tr>
        <tr>
         <th width=20% class="text-center danger">제목</th>
         <td colspan="3"><%=vo.getSubject() %></td>
        </tr>
        <tr>
          <td colspan="4" valign="top" class="text-left" height="200">
            <pre style="white-space: pre-wrap;border:none;background-color: white"><%=vo.getContent() %></pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
           <a href="update.jsp?no=<%=vo.getNo() %>" class="btn btn-xs btn-danger">수정</a>
           <a href="delete.jsp?no=<%=vo.getNo() %>" class="btn btn-xs btn-success">삭제</a>
           <a href="list.jsp" class="btn btn-xs btn-info">목록</a>
          </td>
        </tr>
       </table>
     </div>
   </div>
</body>
</html>






