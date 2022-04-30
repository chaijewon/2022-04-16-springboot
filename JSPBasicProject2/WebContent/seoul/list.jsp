<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%
    //1. 사용자가 보내준 데이터를 받는다 (request) => page
    String strPage=request.getParameter("page");
    /*
         1. 서버에서 인식하는 내용 : 주소란에 있다 
         2. 데이터를 서버로 전송 
            ~/list.jsp?page=1
            		  --------
            ~/list.jsp?page=1&name=...
            
            ~/list.jsp ==> page=null
            ~/list.jsp?page= page=""
    */
    if(strPage==null) // 사용자가 페이지 요청을 하지 않은 경우 (처음 실행)
    	strPage="1"; //default 
    	
    int curpage=Integer.parseInt(strPage); // 문자열에서 정수형으로 변경 
    //2. 데이터베이스를 연결해서 출력할 데이터를 가지고 온다 
    SeoulDAO dao=new SeoulDAO();
    List<HotelVO> list=dao.hotelListData(curpage);
    //2-1 총페이지 읽기
    int totalpage=dao.hotelTotalPage();
    //3. HTML을 이용해서 출력 
    
    // cookie 읽기
    /*
        Cookie cookie=new Cookie("h"+no,no => getValue());
                                 ------ --
                                 getName()
    */
    Cookie[] cookies=request.getCookies();
    List<HotelVO> hList=new ArrayList<HotelVO>();
    if(cookies!=null)
    {
    	for(int i=cookies.length-1;i>=0;i--)
    	{
    		if(cookies[i].getName().startsWith("h"))
    		{
    			String no=cookies[i].getValue();
    			HotelVO vo=dao.hotelDetailData(Integer.parseInt(no));
    			hList.add(vo);
    		}
    	}
    }
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
    <h1>서울 호텔</h1>
    <div class="row">
      <%
          for(HotelVO vo:list)
          {
       %>
              <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="detail_before.jsp?no=<%=vo.getNo()%>">
			        <img src="<%=vo.getPoster() %>"  style="width:320px;height: 250px">
			        <div class="caption">
			          <p style="font-size: 8px"><%=vo.getName() %></p>
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
        <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-primary">이전</a>
          <%= curpage %> page / <%=totalpage %> pages
        <a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-primary">다음</a>
      </div>
    </div>
    <div style="height: 30px"></div>
    <h3>최신본 호텔</h3>
    <hr>
    <div class="row">
      <%
         int k=0;
         for(HotelVO vo:hList)
         {
        	if(k>10)
        		break;
      %>
           <a href="detail.jsp?no=<%=vo.getNo()%>">
            <img src="<%=vo.getPoster() %>" style="width: 100px;height: 100px"
              title="<%=vo.getName() %>"
            >
           </a>
      <%
           k++;
         }
      %>
    </div>
  </div>
</body>
</html>






