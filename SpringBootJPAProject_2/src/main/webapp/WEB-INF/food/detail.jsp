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
  width:800px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
     <table class="table">
       <tr>
         <c:forTokens items="${vo.poster }" delims="^" var="img">
           <td>
             <img src="${img }" style="width:100%">
           </td>
         </c:forTokens>
       </tr>
     </table>
   </div>
   <div class="row">
     <table class="table">
      <tr>
       <td colspan="2"><h3>${vo.name }<span style="color:orange">${vo.score }</span></h3></td>
      </tr>
      <tr>
        <td>주소</td>
        <td>${vo.address }</td>
      </tr>
      <tr>
        <td>전화</td>
        <td>${vo.tel }</td>
      </tr>
      <tr>
        <td>음식종류</td>
        <td>${vo.type }</td>
      </tr>
      <tr>
        <td>영업시간</td>
        <td>${vo.time }</td>
      </tr>
      <tr>
        <td>주차</td>
        <td>${vo.parking }</td>
      </tr>
      <tr>
        <td>메뉴</td>
        <td>${vo.menu }</td>
      </tr>
      <tr>
        <td class="text-right" colspan="2">
          <a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
        </td>
      </tr>
     </table>
   </div>
  </div>
</body>
</html>








