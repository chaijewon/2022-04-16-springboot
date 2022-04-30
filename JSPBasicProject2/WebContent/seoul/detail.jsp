<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*,java.util.*"%>
<%
    // 보내준 데이터 받기 
    String no=request.getParameter("no");
    //1. DAO에서 값을 가지고 온다 
    SeoulDAO dao=new SeoulDAO();
    HotelVO vo=dao.hotelDetailData(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 70px;
}
.row{
   margin: 0px auto;
   width:100%
}
h1{
    text-align: center
}
</style>
</head>
<body>
   <div class="container">
    <h1><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h1>
    <div class="row">
      <table class="table">
       <tr>
         <td colspan="5" class="text-center">
          <img src="<%=vo.getPoster() %>" width=100%>
         </td>
       </tr>
       <tr>
         <%
             System.out.println("images:"+vo.getImages());
             StringTokenizer st=new StringTokenizer(vo.getImages(),"^");
             while(st.hasMoreTokens())
             {
         %>
                <td><img src="<%=st.nextToken() %>" width=100%></td>
         <%
             }
         %>
       </tr>
       <tr>
         <td width=10%>주소</td>
         <td colspan="4"><%=vo.getAddress() %></td>
       </tr>
       <tr>
         <td colspan="5" class="text-right">
           <a href="list.jsp" class="btn btn-sm btn-danger">목록</a>
         </td>
       </tr>
      </table>
    </div>
   </div>
</body>
</html>






