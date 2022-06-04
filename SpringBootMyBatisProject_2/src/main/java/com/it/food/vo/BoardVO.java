package com.it.food.vo;
/*
	 *  no int AI PK 
	name varchar(34) 
	subject varchar(1000) 
	content text 
	pwd varchar(10) 
	regdate datetime 
	hit int
 */

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BoardVO {
   private int no,hit;
   private String name,subject,content,pwd;
   private Date regdate;
}
