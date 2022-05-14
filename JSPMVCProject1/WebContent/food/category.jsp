<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.it.model.FoodModel"/>
<%
     model.foodCategoryData(request);//request를 Model로 보내주고 결과값을 추가 재전송 요청
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
   width:100%;
}
h1{
    text-align: center
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3>믿고 보는 맛집 리스트</h3>
      <%-- varStatus => List의 index번호 --%>
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index<12 }">
         <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
      <hr>
      <h3>지역별 인기 맛집</h3>
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=12 && s.index<18 }">
         <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
      <hr>
      <h3>메뉴별 인기 맛집</h3>
      <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=18 && s.index<30 }">
         <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
        </c:if>
      </c:forEach>
      <hr>
    </div>
  </div>
</body>
</html>

