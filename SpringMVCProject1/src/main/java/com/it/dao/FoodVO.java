package com.it.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   no int PK 
cno int 
poster varchar(2000) 
name varchar(300) 
score double 
address varchar(2000) 
tel varchar(20) 
type varchar(100) 
price varchar(30) 
time varchar(50) 
parking varchar(100) 
menu varchar(4000)
 */
@Getter
@Setter
public class FoodVO {
  private int no,cno;
  private double score;
  private String poster,name,address,tel,type,price,time,parking,menu;
}







