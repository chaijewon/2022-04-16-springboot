package com.it.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *     no int, 
       name varchar(100), 
       address varchar(200), 
	   poster varchar(200),
	   msg varchar(1000)
 */
// JSP => 1.라이브러리 
// 2. VO설정 
// 3. 데이터베이스 연결 
// 4. JSP => 화면구현 
// ==> request, response , cookie 
@Getter
@Setter
public class SeoulVO {
  private int no;
  private String name,address,poster,msg;
}
