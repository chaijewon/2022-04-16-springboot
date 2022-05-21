package com.it.web;

import org.springframework.stereotype.Repository;

@Repository //id는 자동 설정
public class BoardDAO {
  public void getConnection()
  {
	  System.out.println("MySQL 연결");
  }
  public void disConnection()
  {
	  System.out.println("MySQL 해제");
  }
  public void write()
  {
	  //getConnection();
	  System.out.println("MySQL 데이터 추가");
	  //disConnection();
  }
  public void list()
  {
	  //getConnection();
	  System.out.println("MySQL 데이터 목록 보기");
	  //disConnection();
  }
  public void update()
  {
	  //getConnection();
	  System.out.println("MySQL 데이터 수정");
	  //disConnection();
  }
  public void delete()
  {
	  //getConnection();
	  System.out.println("MySQL 데이터 삭제");
	  //disConnection();
  }
}
