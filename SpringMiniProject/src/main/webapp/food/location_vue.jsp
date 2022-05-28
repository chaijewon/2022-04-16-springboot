<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 30px;
}
.row {
   margin: 0px auto;
   width:100%;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
  <div class="bgded overlay" style="background-image:url('../images/demo/backgrounds/back.png');">
  <div id="breadcrumb" class="hoc clear"> 
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="hoc container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">지역별 맛집 찾기</header>
          <div class="inline">
           Search:<input type=text size=30 class="input-sm" v-model="ss">
           <button class="btn btn-sm btn-danger" v-on:click="search()"></button>
          </div>
          <div style="height: 50px"></div>
         
          <ul class="nospace clear">
             
          </ul>
        </figure>
      </div>
      <!-- ################################################################################################ -->
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
           
        </ul>
      </nav>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <div class="clear"></div>
  </main>
</div>
   <script>
    new Vue({
    	el:'.container',
    	data:{
    		ss:'강남',
    		find_data:[],
    		curpage:1,
    		totalpage:0
    	},
    	mounted:function(){
    		// 첫페이지
    		this.getData();
    	},
    	methods:{
    		getData:function(){
    			axios.get("http://localhost/web/food/rest_find.do",{
    				params:{
    					page:this.curpage,
    					ss:this.ss
    				}
    			    // function(response){}
    			}).then(response=>{
    				console.log(response.data);
    				this.find_data=response.data;
    				this.curpage=this.find_data[0].curpage
    				this.totalpage=this.find_data[0].totalpage
    			})
    		},
    		search:function(){
    			
    		},
    		pageChange:function(page){
    			
    		}
    	}
    })
   </script>
</body>
</html>