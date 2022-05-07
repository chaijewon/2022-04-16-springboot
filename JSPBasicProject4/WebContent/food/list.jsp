<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.FoodDAO"/>
<%--
       FoodDAO dao=new FoodDAO();
 --%>
<%
    request.setCharacterEncoding("UTF-8");// 한글이 있는 경우 
    // 데이터 읽기
    String ss=request.getParameter("ss");
    if(ss==null)
    	ss="강남";
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    
    // 현재 페이지 지정 
    int curpage=Integer.parseInt(strPage);
    // 현재 페이지에 대한 데이터 읽기
    List<FoodVO> list=dao.foodFindData(ss, curpage);
    // 총페이지 
    int totalpage=dao.foodTotalPage(ss);
    // 페이지 나누기 
    final int BLOCK=5;
    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
    if(endPage>totalpage)
    	endPage=totalpage;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
  margin-top: 50px;
}
.row {
  margin: 0px auto;
  width: 100%;
}
h1 {
   text-align: center;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
     <div class="text-center">
      <form method="post" action="list.jsp">
       <input type=text name=ss size=35 class="input-sm" value="<%=ss%>">
       <input type=submit value="검색" class="btn btn-sm btn-primary">
      </form>
     </div>
    </div>
    <div style="height: 100px"></div>
    <div class="row">
     <%
       for(FoodVO vo:list)
       {
     %>
      <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="<%=vo.getPoster() %>" style="width:100%">
	        <div class="caption">
	          <p><%=vo.getName() %></p>
	        </div>
	      </a>
	    </div>
	  </div>
	  <%
	   }
	  %>
    </div>
    <div class="row">
      <div class="text-center">
         <ul class="pagination">
             <%
                  if(startPage>1) //startPage=1,4,7...
                  {
                	  %>
 			         <li><a href="list.jsp?page=<%=startPage-1%>&ss=<%=ss%>">&lt;</a></li>
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
 			          <li <%=css %>><a href="list.jsp?page=<%=i%>&ss=<%=ss%>"><%=i %></a></li>
 			  <%
 			      }
 			  %>
 			  <%
 			     if(endPage<totalpage)
 			     {
 			  %>
 			        <li><a href="list.jsp?page=<%=endPage+1%>&ss=<%=ss%>">&gt;</a></li>
 			  <%
 			     }
 			  %>
 			</ul>
      </div>
    </div>
  </div>
</body>
</html>




