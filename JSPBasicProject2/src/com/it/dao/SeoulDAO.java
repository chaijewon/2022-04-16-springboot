package com.it.dao;
import java.sql.*;
/*
 *    MySQL연결 => 연결객체 => Connection
 *    SQL문장 전송 / (송수신) => Statement 
 *       = Statement (데이터+SQL)
 *       = PreparedStatement (SQL전송 => 나중에 데이터 전송) => default
 *       = CallableStatement (Procedure호출) 
 *    결과값을 받아서 저장 : ResultSet 
 *    
 *    JDBC 실행 
 *    1. 드라이버 등록  (thin드라이버) => 한번만 등록 (생성자)
 *       Class.forName(드라이버 등록) => 리플렉션 (클래스의 정보를 읽어서 제어)
 *         => 마이바티스 , 스프링 (메모리 할당) 
 *    2. MySQL연결 
 *       Connection conn=DriverManager.getConnection(URL,"username","password")
 *    3. SQL문장 전송 
 *       ---------
 *       PreparedStatement ps=conn.prepareStatement(SQL문장)
 *       ps.executeQuery() : 검색 (SELECT) => 결과값을 읽어 온다 (commit(X))
 *       ps.executeUpdate() : 추가(INSERT),수정(UPDATE),삭제(DELETE) 
 *                            ==> 데이터베이스 변경 (commit()) => 자바는 autocommit
 *    4. ResultSet rs=ps.exeuteQuery()
 *       ==========
 *       boolean rs.next() => 처음부터 ~ 데이터가 없을때 까지  => EOF
 *       boolean rs.previous() => 마지막부터 위로 올라가면서 처리 => BOF
 *       ==> 단위가 Record단위 
 *       SELECT no,name,msg,address,poster FROM seoul_hotel
 *       --------------------------------------------------
 *         no     name    msg    address    poster 
 *       --------------------------------------------------
 *        1       aaa     aaa     aaa        aaa
 *        getInt(1) getString(2) getString(3) getString(4) getString(5)
 *         ==> 읽어오는 데터형을 매칭한다 
 *         
 *         1. 정수 => getInt()
 *         2. 문자 => getString()
 *         3. 실수 => getDouble()
 *         4. 날짜 => getDate()
 *       --------------------------------------------------
 *        2       bbb     bbb     bbb        bbb
 *       --------------------------------------------------
 *       
 *       while(rs.next())
 *       {
 *          
 *       }
 *     5. ResultSet => close()
 *        PreparedStatement => close()
 *        Connection => close()
 *        
 *        ** 연결/닫기 반복 => 연결만 하기 (닫기가 없으면 => Connection)
 *           -------- 연결하는 시간이 많이 소모 (미리연결 => 연결된 Connection을 사용)
 *                                       -------------------------- DBCP 
 *       
 */
import java.util.*;
public class SeoulDAO {
    // 연결 객체 
	private Connection conn;
	// SQL문장 전송 객체
	private PreparedStatement ps;
	// URL 선언 
	private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	
	// 드라이버 등록 
	public SeoulDAO() // 한번 실행 , 시작과 동시에 등록 , 멤버변수 초기화 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	// 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"root","1111");
			// conn root/1111
		}catch(Exception ex) {}
	}
	// 해제 
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// 기능
	// 1. 호텔 목록 출력 (HotelVO=Hotel한개에 정보) => 12개 ==> 묶어서 처리 => List
	public List<HotelVO> hotelListData(int page)
	{
		List<HotelVO> list=new ArrayList<HotelVO>();
		try
		{
			// 정상 수행 
			//1. MySQL연결 
			getConnection();
			//2. SQL문장 
			String sql="SELECT no,name,poster "
					  +"FROM seoul_hotel "
					  +"ORDER BY no ASC "
					  +"limit ?,?";
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			// 1page => 12*1-12 => 0
			// 2page => 12*2-12 => 12
		    //3. SQL문장 전송 
			ps=conn.prepareStatement(sql);
			//4. ?에 값을 채운다 
			ps.setInt(1, start);
			ps.setInt(2, rowSize);
			//5. 실행후 결과값 받기 
			ResultSet rs=ps.executeQuery();
			// rs=> 실행 모든 결과가 있다
			while(rs.next())
			{
				// 한줄씩 읽어 온다 
				HotelVO vo=new HotelVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			// 오류 발생시 처리
		}
		finally
		{
			// 데이터베이스 닫기 
		}
		return list;
	}
	// 2. 총페이지 읽기 
	public int hotelTotalPage()
	{
		int total=0;
		try
		{
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_hotel";
			// 3. MYSQL로 전송 
			ps=conn.prepareStatement(sql);
			// 4. ?가 없으면 실행 요청 => 결과값 받기
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
			// try , catch를 수행하든 상관없이 무조건 수행되는 문장 
			disConnection();
		}
		return total;
	}
	// 3. 상세보기 => 매개변수는 사용자가 요청한 값 => request,response,cookie 
	public HotelVO hotelDetailData(int no)
	{
		HotelVO vo=new HotelVO();
		try
		{
			// 1. 연결
			getConnection();
			// 2. SQL문장을 만든다 
			String sql="SELECT no,name,score,address,poster,images FROM seoul_hotel "
					  +"WHERE no="+no; // Statement
			ps=conn.prepareStatement(sql);
			// 3. ?가 있으면 채운다  ==> 통과 
			// 4. 실행요청 => 결과값을 받는다
			ResultSet rs=ps.executeQuery();// no,name,score,address,poster,images
			rs.next();
			// 5. 값을 (VO에 값을 채운다)
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setScore(rs.getDouble(3));
			vo.setAddress(rs.getString(4));
			vo.setPoster(rs.getString(5));
			vo.setImages(rs.getString(6));
			System.out.println(vo.getImages());
			// 6. ResultSet => close()
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			// 닫기 
			disConnection(); // 메소드 => 1. 한개의 기능 수행 (재사용)
			// 2. 반복이 있는 경우 
			// 3. 구조적인 프로그램 (단락) => 가독성 
		}
		return vo;
	}
	// 4. 검색 => LIKE 
}















