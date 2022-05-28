<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
       <div id="app1">
         {{$data}}
         <h1>이름:{{name}}</h1>
       </div>
       <div id="app2">
         {{$data}}
         <h1>이름:{{name}}</h1>
       </div>
     </div>
   </div>
   <script>
    new Vue({
    	el:'#app1',
    	data:{
    		name:'홍길동'
    	}
    })
    new Vue({
    	el:'#app2',
    	data:{
    		name:'심청이'
    	}
    })
   </script>
</body>
</html>