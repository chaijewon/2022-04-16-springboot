package com.it.dao;
import java.util.*; // 게시문 데이터를 모아서 전송 => List
import java.sql.*; // 연결 (Connection), PreparedStatement(SQL문장 전송) , ResultSet(결과값)
public class BoardDAO {
   private Connection conn;//연결 객체 
   private PreparedStatement ps; //SQL문장 => 전송 => 결과값 받기 
   private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
   private final String USERNAME="root";
   private final String PASSWORD="1111";
   
   // Driver등록 => 한번만 수행 => 생성자 
   public BoardDAO()
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
   // 기능 처리 
   // 1. 목록 출력 => 페이지나누기 (SELECT)
   // 게시물 정보 한개 : BoardVO (레코드) , 게시물 여러개 (List)
   public List<BoardVO> boardListData(int page) // 블록단위 [1][2][3]...
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   try
	   {
		   // 정상수행 문장 
		   // 1. 연결 
		   getConnection();
		   // 2. SQL제작 
		   int rowSize=10;
		   int start=(rowSize*page)-rowSize;
		   // limit => 0  (1page) , 10 (2page) ==> 10개씩 읽는다 
		   // limit 0,10 , 10,10 , 20,10....
		   String sql="SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d'),hit "
				     +"FROM jspBoard "
				     +"ORDER BY no DESC "
				     +"limit ?,?";
		   // 3. 전송 
		   ps=conn.prepareStatement(sql);
		   // 4. 데이터 채우기 
		   ps.setInt(1, start);
		   ps.setInt(2, rowSize);
		   // 5. 실행요청 => 결과값 저장 
		   ResultSet rs=ps.executeQuery();
		   // 6. 저장위치로부터 데이터를 읽어서 => List저장 
		   while(rs.next())
		   {
			   BoardVO vo=new BoardVO();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setDbday(rs.getString(4));
			   vo.setHit(rs.getInt(5));
			   list.add(vo);
		   }
		   // 7. 닫기 
		   rs.close();
	   }catch(Exception ex)
	   {
		   // 오류처리 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // SQL문장을 실행 / 미실행 => 무조건 닫는다 (try,catch와 상관없이 무조건 수행)
		   disConnection();
	   }
	   return list;
   }
   // 2. 총페이지 (SELECT => CEIL)
   public int boardTotalPage()
   {
	   int total=0;
	   try
	   {
		   //1. 연결 
		   getConnection();
		   //2. SQL
		   String sql="SELECT CEIL(COUNT(*)/10.0) FROM jspBoard";
		   ps=conn.prepareStatement(sql);
		   //3. 실행 
		   ResultSet rs=ps.executeQuery();
		   //4. 결과값 받기 
		   rs.next(); // 커서위치 변경 
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();// 닫기
	   }
	   return total;
   }
   // 3. 새글 올리기 (INSERT) => <jsp:useBean> <jsp:setProperty> 
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   //1. 연결  ==> 흐름 
		   getConnection();
		   //2. SQL문장 
		   String sql="INSERT INTO jspBoard(name,subject,content,pwd,regdate) "
				     +"VALUES(?,?,?,?,now())";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   
		   // 실행 ==> commit => java => autocommit
		   ps.executeUpdate(); //commit포함 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 4. 상세보기 => 조회수 올리기 (UPDATE), 상세내용 (SELECT) 
   public BoardVO boardDetailData(int no)//사용자가 요청한 데이터는 매개변수 
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   //1. 연결 
		   getConnection();
		   //2. SQL문장 
		   String sql="UPDATE jspBoard SET "
				     +"hit=hit+1 "
				     +"WHERE no=?"; // 조회수 증가 
		   ps=conn.prepareStatement(sql);
		   //?에 값을 채운다
		   ps.setInt(1,no);
		   // 실행 요청 
		   ps.executeUpdate();
		   
		   //2. 실제 데이터를 가지고 온다 
		   sql="SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d'), hit "
		      +"FROM jspBoard "
			  +"WHERE no=?";
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return vo;
   }
   // 5. 수정 => 비밀번호 확인 (UPDATE,SELECT) 
   // 6. 삭제 => 비밀번호 확인 (DELETE,SELECT)
   
}




