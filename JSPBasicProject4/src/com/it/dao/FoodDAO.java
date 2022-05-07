package com.it.dao;
import java.util.*;
import java.sql.*;
public class FoodDAO {
	private Connection conn;//연결 객체 
	   private PreparedStatement ps; //SQL문장 => 전송 => 결과값 받기 
	   private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	   private final String USERNAME="root";
	   private final String PASSWORD="1111";
	   
	   // Driver등록 => 한번만 수행 => 생성자 
	   public FoodDAO()
	   {
		   try
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");// 메모리 할당 => new Driver()
			   // => 리플렉션 : 클래스의 정보를 읽어서 제어(생성자,메모리할당,멤버변수,메소드)
			   // => 스프링 => 클래스 관리자 (객체생성 ~ 소멸 ==> 객체의 생명주기) => DI
			   // 객체: 컴포넌트 ==> 컨테이너 (스프링 => 컨테이너) 
			   // 반드시 => 패키지명부터 입력 => 클래스명까지 
		   }catch(Exception ex) 
		   {
			   ex.printStackTrace();
		   }
		   /*
		    *    Class<?> java.lang.Class.forName(String className) 
		    *    throws ClassNotFoundException
		    *           ----------------------- 컴파일 예외처리 (체크 예외) 
		    *           반드시 => 예외처리후에 사용 
		    *    자바 :  1) 컴파일  ==> A.java => A.class(바이트 코드)
		    *                      원시소스         바이너리파일 (컴퓨터 인식)
		    *                       ==> 발생하는 예외는 반드시 예외처리를 한다 
		    *                       IOException
		    *                       ClassNotFoundException 
		    *                       SQLException 
		    *                       InterrupedException 
		    *                       Net관련 
		    *                       ----------------------- 체크 Exception
		    *           2) 인터프리터 => 실행시 에러 => Exception생략이 가능 
		    *                          RuntimeException 
		    *                                              
		    */
	   }
	   // MySQL연결 ==> 연결하는 시간이 많이 소모가 된다 ==> 미리 Connection을 연결하고 연결된 conn을 사용한다 
	   // DBCP => 웹 프로그램의 일반화 ==> 일반 JDBC
	   // <jsp:include> , 내장 객체 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		   }catch(Exception ex){}
	   }
	   // MySQL닫기 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {} 
	   }
	   // 맛집 찾기 
	   // <jsp:include> , JSTL / EL / MVC / Annotation / XML 
	   public List<FoodVO> foodFindData(String loc,int page)
	   {
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   try
		   {
			   //1. 연결 
			   getConnection();
			   //2. SQL문장  ==> '%'||?||'%' => 오라클 
			   // CONCAT('%',?,'%') => MySQL , MariaDB 
			   String sql="SELECT no,poster,name "
					     +"FROM food_location "
					     +"WHERE address LIKE CONCAT('%',?,'%') "
					     +"limit ?,?";
			   int rowSize=12;
			   int start=(rowSize*page)-rowSize;
			   //3. MySQL로 전송 
			   ps=conn.prepareStatement(sql);
			   //3-1. ?에 값을 채운다 
			   ps.setString(1, loc);
			   ps.setInt(2, start);
			   ps.setInt(3, rowSize);
			   //4. 결과값을 	받는다 
			   ResultSet rs=ps.executeQuery();
			   //5. 결과값을 List에 담는다 
			   while(rs.next())
			   {
				   FoodVO vo=new FoodVO();
				   vo.setNo(rs.getInt(1));
				   vo.setPoster(rs.getString(2));
				   vo.setName(rs.getString(3));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();// 에러 확인 
		   }
		   finally
		   {
			   disConnection();// 연결 종료 
		   }
		   return list;
	   }
	   // 총페이지 
	   public int foodTotalPage(String loc)
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/12.0) "
					     +"FROM food_location "
					     +"WHERE address LIKE CONCAT('%',?,'%')";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, loc);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return total;
	   }
}








