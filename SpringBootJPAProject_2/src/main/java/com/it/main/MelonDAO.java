package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MelonDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	   
	   // 드라이버 등록 
	   public MelonDAO()
	   {
		   try
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");
		   }catch(Exception ex){}
	   }
	   // 연결 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"root","1111");
		   }catch(Exception ex) {}
	   }
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   /*
	    *  no int,
		   title varchar(500) not null,
		   singer varchar(200) not null,
		   album varchar(500) not null,
		   poster varchar(260) not null,
		   mkey varchar(50) not null
	    */
	   public void melonInsert(MelonVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO music VALUES(?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getNo());
			   ps.setString(2, vo.getTitle());
			   ps.setString(3, vo.getSinger());
			   ps.setString(4, vo.getAlbum());
			   ps.setString(5, vo.getPoster());
			   ps.setString(6, vo.getMkey());
			   ps.executeUpdate();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
	   
}
