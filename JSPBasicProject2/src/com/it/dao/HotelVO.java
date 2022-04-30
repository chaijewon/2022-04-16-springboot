package com.it.dao;

import lombok.Getter;
import lombok.Setter;

// hotel 한개에 대한 데이터 모아서 사용 
/*
 *   no int, 
	 name varchar(100), 
	 score double, 
	 address varchar(200), 
	 poster varchar(200),
	 images varchar(1000)
	 
	 MySql      Java   => 데이터형 매칭
	 숫자형 
	  int        int
	  double     double
	 문자형 
	  varchar    String 
	  char 
	  text
	 날짜형 
	  detetime  java.util.Date
 */
@Getter
@Setter
public class HotelVO {
   private int no;
   private double score;
   private String name,address,poster,images;
}









