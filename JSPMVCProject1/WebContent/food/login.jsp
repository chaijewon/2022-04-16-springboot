<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   width:300px;
}
h1{
    text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>Login</h1>
     <div class="row">
      <form method=post action="login_ok.jsp">
       <table class="table">
         <tr>
           <th class="text-center success" width="30%">ID</th>
           <td width="70%">
             <input type=text name="id" size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <th class="text-center success" width="30%">PW</th>
           <td width="70%">
             <input type=password name="pwd" size=15 class="input-sm">
           </td>
         </tr>
         <tr>
           <td colspan="2" class="text-center">
             <button class="btn btn-sm btn-danger">로그인</button>
           </td>
         </tr>
       </table>
       </form>
     </div>
   </div>
</body>
</html>






