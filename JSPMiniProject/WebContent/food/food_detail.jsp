<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib 설정--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
  <div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li>맛집 상세보기</li>
    </ul>
    <!-- ################################################################################################ --> 
   </div>
  </div>
  <div class="wrapper row3">
   <main class="container clear">
     <div class="content">
	   <%-- 이미지 출력--%>
	  </div>
    <div class="clear"></div>
    <div class="content two_quarter first"> 
	  <%-- 상세 내용 출력--%>
	 <div id="comments">
        <h2>리뷰(댓글)</h2>
        <ul>
         <c:forEach var="rvo" items="${rList }">
	          <li>
	            <article>
	              <header>
	                <figure class="avatar">
	                   <%-- 수정 , 삭제--%>
	                </figure>
	                <address>
	                By <a href="#"><%-- 이름 ,날짜 출력--%></a>
	                </address>
	              </header>
	              <div class="comcont">
	                <p><pre style="white-space:pre-wrap;background-color:white;border:none"><%--내용출력--%></pre></p>
	              </div>
	            </article>
	            <table class="table ups" id="m${rvo.no }" style="display:none">
	             <tr>
	               <td>
	                 <form method=post action="#">
	                     
	                     <input type=hidden name=tp value="1">
		                 <textarea rows="5" name="msg" cols="48" style="float:left"><%--수정내용--%></textarea>
		                  <input type=submit value="댓글수정" class="btn btn-primary"
		                  style="height: 30px">
	                 </form>
	               </td>
	             </tr>
	           </table>
	          </li>
	         
          </c:forEach>
          </ul>
        </div>
        <c:if test="${sessionScope.id!=null }"><%--로그인이 된 상태 --%>
	        <table class="table">
	             <tr>
	               <td>
	                 <form method=post action="#">
	                    <%-- hidden 내용--%>
		                 <textarea rows="5" name="msg" cols="48" style="float:left"></textarea>
		                  <input type=submit value="댓글쓰기" class="btn btn-primary"
		                  style="height: 105px">
	                 </form>
	               </td>
	             </tr>
	           </table>
        </c:if>
	</div>
	<div class="content two_quarter second">
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
		geocoder.addressSearch('${vo.addr1}', function(result, status) {
		
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
	
   </main>
   </div>

  
</body>
</html>












