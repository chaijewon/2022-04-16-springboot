<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      VueJS => AngularJS 
      ------
      1) 형식
         <script>
           new Vue({
              el:제어하는 태그명 / ID(#)/CLASS(.),
              data:멤버변수 ,
              mounted: window-onload
              mothods:{
                             사용자 정의 함수
              }
           })
           new Vue({
           })
           new Vue({
           })
         </script>
      2) 디렉티브 : 제어문 => v-if , v-for , v-show ....
      3) 이벤트 처리 : v-on:click=""
      4) 컴포넌트 : Vue.component{}
      5) 사용자 정의 이벤트 => methods:{}
      6) 서버 연결 => axios.get(url,데이터).then(결과값)
      7) 라우트 (화면변경) 
      8) vue-cli
      ============== 양방향 , 가상돔(속도가 빠르다), 사용하기 편리하기 (Jquery => Vue,React)
         일반 : View(VueJS) , MVC(Vuex)
          View(React) , MVC(Redux) 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <h1 class="text-center">{{message}}</h1>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		message:'Hello Vue!!'
    		/*
    		     일반 문자열 :  => name:'' 
    		     일반 숫자 :   => page:1
    		     배열:       => food:[]
    		     객체단위 :   => food:{}
    		*/
    	},
    	beforeCreate:function(){
    		console.log("beforeCreate:생성전...")
    	},
    	created:function(){
    		console.log("created:메모리 할당 완료...")
    	},
    	beforeMount:function(){
    		console.log("beforeMount:화면 출력하기 전...")// componentWillMount
    	},
    	mounted:function(){
    		console.log("mountd:화면 출력완료 (window.onload:$(function(){}))...")
    		// // componentDidMount =>외부에서 데이터 읽기 
    	},
    	beforeUpdate:function(){
    		console.log("beforeUpdate:수정하기 전...")
    	},
    	updated:function(){
    		console.log("updated:수정완료...")
    	},
    	beforeDestory:function(){
    		console.log("beforeDestory:화면이동 전 (메모리해제 전)...")
    	},
    	destoryed:function(){
    		console.log("destoryed:메모리 해제...")
    	}
    })
  </script>
</body>
</html>