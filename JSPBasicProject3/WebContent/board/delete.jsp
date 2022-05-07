<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 사용자가 요청한 데이터 받기 
    String no=request.getParameter("no");
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
  width: 350px;
}
h1 {
   text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/*
 *   자바스크립트 : window.onload=function(){}
 *   VueJS : mounted ==> Vue3 ==> Vuex(MVC)
     React : componentDidMount()
     Redux : useEffect() => MVC ==> Mobx , Saga ...(FrameWork)
 */
$(function(){ 
	// 입력된 데이터 읽기 
	// $('#delBtn').on('click',function(){})
	// $() => 태그 읽기 => 제어 
	/*
	    # => id 
	    . => class 
	    태그명 , 형제 , 후손 , 인접 (SELECTOR => CSS)
	    $('tr') 태그명 
	    $('tr+td') 인접
	    $('tr < td') 자손 
	    $('tr td') 후손 
	    
	       div  (선택자 : CSS)
	        |
	    ------------
	    |   |      |
	   p   span   span
	   ==> div < p+span
	               | 
	              span
	         div span 
	         
	*/
	$('#delBtn').click(function(){
		let pwd=$('#pwd').val();
		if(pwd.trim()=="") // 비밀번호 입력값 확인 
		{
			$('#pwd').focus();
			return;
		}
		// XML => JSON (객체 표현법) => 스프링 (@RestController, @ResponseBody)
		//        모바일(Kotlin) , 자바스크립트 
		$.ajax({
			type:'POST',
			url:'delete_ok.jsp',
			data:{"no":$('#no').val(),"pwd":pwd},
			success:function(res)
			{
				let r=res.trim();
				if(r==0)
				{
					alert("비밀번호가 틀립니다!!");
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					location.href="list.jsp";
				}
			}
		})
	})
	
	
})
</script>
</head>
<body>
   <div class="container">
     <h1>삭제하기</h1>
     <div class="row">
       <table class="table">
         <tr>
           <td class="text-center">
           비밀번호:<input type=password name=pwd size=15 class="input-sm" id="pwd">
           <input type=hidden name=no value="<%=no%>" id="no">
           </td>
         </tr>
         <tr>
           <td class="text-center">
            <input type=button value="삭제" class="btn btn-sm btn-success" id="delBtn">
            <input type=button value="취소" class="btn btn-sm btn-info"
             onclick="javascript:history.back()"
            >
           </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>







