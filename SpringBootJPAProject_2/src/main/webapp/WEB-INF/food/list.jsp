<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.row{
  margin: 0px auto;
  width:1200px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <form method="post" action="/food_find">
      <input type=text name=address size=30 class="input-sm" value="${address }">
      <button class="btn btn-sm btn-danger">검색</button>
     </form>
    </div>
    <div style="height: 30px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="/food_detail?no=${vo.no }">
	          <img src="${vo.poster }" alt="Lights" style="width:100%">
	          <div class="caption">
	            <p>${vo.name }</p>
	          </div>
	        </a>
	      </div>
	    </div>
      </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <a href="/food_find?address=${address }&page=${curpage>1?curpage-1:curpage}" class="btn btn-sm btn-primary">이전</a>
        ${curpage } page / ${totalpage } pages
        <a href="/food_find?address=${address }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-primary">다음</a>
      </div>
    </div>
  </div>
  
</body>
</html>