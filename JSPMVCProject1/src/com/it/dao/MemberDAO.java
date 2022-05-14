package com.it.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	   private Connection conn;
	   private PreparedStatement ps; //SQL문장 => 전송 => 결과값 받기 
	   private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	   private final String USERNAME="root";
	   private final String PASSWORD="1111";
	   
	   // Driver등록 => 한번만 수행 => 생성자 
	   public MemberDAO()
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
	   // 로그인 처리 => session 
	   public String isLogin(String id,String pwd)
	   {
		   String result=""; // 1. id , 2. pwd , 3. login
		   try
		   {
			   // 1. 연결
			   getConnection();
			   // 2. sql문장 
			   String sql="SELECT COUNT(*) FROM member "
					     +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   // ?에 값을 채운다 
			   ps.setString(1, id);
			   // 실행후 결과값 읽기 
			   ResultSet rs=ps.executeQuery();
			   rs.next(); // 출력한 메모리 위치로 이동 => 데이터를 읽기
			   int count=rs.getInt(1);
			   rs.close();
			   if(count==0)//ID가 존재하지 않는 경우
			   {
				   result="NOID";
			   }
			   else //ID가 존재하는 상태
			   {
				   // 비밀번호 검색 
				   sql="SELECT pwd,name FROM member "
					  +"WHERE id=?";
				   ps=conn.prepareStatement(sql); // JDBC
				   ps.setString(1, id);
				   rs=ps.executeQuery();
				   rs.next();
				   String db_pwd=rs.getString(1);
				   String name=rs.getString(2);
				   rs.close();
				   
				   if(db_pwd.equals(pwd))//로그인 
				   {
					   result=name;
				   }
				   else//비밀번호가 틀린 상태 
				   {
					   result="NOPWD";
				   }
				   
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();//예외처리 (에러 확인)
		   }
		   finally
		   {
			   // MySQL닫기
			   disConnection();
		   }
		   return result;
	   }
	   
}
