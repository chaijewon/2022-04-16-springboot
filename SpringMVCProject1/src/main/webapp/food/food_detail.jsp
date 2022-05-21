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
.row {
  margin: 0px auto;
  width: 960px;
}
h1 {
   text-align: center;
}
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=676eb5fa2637b234997b24dd7566e9ba&libraries=services"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <c:forTokens items="${vo.poster }" delims="^" var="img">
            <td class="text-center">
              <img src="${img }" width=100%>
            </td>
          </c:forTokens>
        </tr>
      </table>
    </div>
    <div style="height: 50px"></div>
    <div class="col-sm-8">
      <table class="table">
        <tr>
          <td colspan="2">
           <h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
          </td>
        </tr>
        <tr>
          <td width=15%>주소</td>
          <td width=85%>${vo.address }</td>
        </tr>
        <tr>
          <td width=15%>전화</td>
          <td width=85%>${vo.tel }</td>
        </tr>
        <tr>
          <td width=15%>음식종류</td>
          <td width=85%>${vo.type }</td>
        </tr>
        <tr>
          <td width=15%>영업시간</td>
          <td width=85%>${vo.time }</td>
        </tr>
        <tr>
          <td width=15%>주차</td>
          <td width=85%>${vo.parking }</td>
        </tr>
        <c:if test="${vo.menu!='no' }">
	        <tr>
	          <td width=15%>메뉴</td>
	          <td width=85%>
	            <ul>
	              <c:forTokens items="${vo.menu }" delims="원" var="m">
	               <li>${m }원</li>
	              </c:forTokens>
	            </ul>
	          </td>
	        </tr>
        </c:if>
      </table>
    </div>
    <div class="col-sm-4">
       <div id="map" style="width:100%;height:350px;"></div>

		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=676eb5fa2637b234997b24dd7566e9ba&libraries=services"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${addr1}', function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
    </div>
  </div>
</body>
</html>






